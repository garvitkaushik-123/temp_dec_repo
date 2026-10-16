package io.bidmachine.rendering.internal.adform.video;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.internal.adform.video.a;
import io.bidmachine.rendering.internal.adform.video.player.d;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.repository.a;
import io.bidmachine.rendering.measurer.VideoMeasurer;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MediaSource;
import io.bidmachine.rendering.model.Resource;
import io.bidmachine.rendering.model.ResourceSource;
import io.bidmachine.rendering.model.UrlResourceSource;
import io.bidmachine.rendering.utils.UiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0015\u0017BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u0015\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\u001cJ\u000f\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010\u001cJ\u000f\u0010#\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010\u001cJ\u0019\u0010\u0017\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b\u0017\u0010&J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b\u0015\u0010&J\u000f\u0010'\u001a\u00020\u0014H\u0016¢\u0006\u0004\b'\u0010\u001cJ\u000f\u0010(\u001a\u00020\u0014H\u0016¢\u0006\u0004\b(\u0010\u001cJ\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u001cJ\u000f\u0010)\u001a\u00020\u0014H\u0014¢\u0006\u0004\b)\u0010\u001cJ\u000f\u0010*\u001a\u00020\u0014H\u0007¢\u0006\u0004\b*\u0010\u001cR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lio/bidmachine/rendering/internal/adform/video/a;", "Lio/bidmachine/rendering/internal/adform/a;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "Lio/bidmachine/rendering/measurer/VideoMeasurer;", "videoMeasurer", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;Lio/bidmachine/rendering/measurer/VideoMeasurer;)V", "Lio/bidmachine/rendering/model/Error;", "error", "", "a", "(Lio/bidmachine/rendering/model/Error;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "v", "()Landroid/view/View;", "c", "()V", "Landroid/view/ViewGroup;", "viewGroup", "(Landroid/view/ViewGroup;)V", "d", InneractiveMediationDefs.GENDER_FEMALE, "z", "w", "", "senderId", "(Ljava/lang/Integer;)V", CampaignEx.JSON_KEY_AD_K, "e", VastAttributes.HORIZONTAL_POSITION, "C", "r", "Lio/bidmachine/rendering/measurer/VideoMeasurer;", "Lio/bidmachine/rendering/internal/adform/video/player/b;", "s", "Lio/bidmachine/rendering/internal/adform/video/player/b;", "player", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a extends io.bidmachine.rendering.internal.adform.a {

    /* renamed from: r, reason: from kotlin metadata */
    private final VideoMeasurer videoMeasurer;

    /* renamed from: s, reason: from kotlin metadata */
    private io.bidmachine.rendering.internal.adform.video.player.b player;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\r\u0010\u0015J!\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\r\u0010\u0018J\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\r\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\b¨\u0006\u001d"}, d2 = {"Lio/bidmachine/rendering/internal/adform/video/a$a;", "Lio/bidmachine/rendering/internal/adform/video/player/d;", "<init>", "(Lio/bidmachine/rendering/internal/adform/video/a;)V", "Lio/bidmachine/rendering/internal/adform/video/player/b;", "player", "", InneractiveMediationDefs.GENDER_FEMALE, "(Lio/bidmachine/rendering/internal/adform/video/player/b;)V", "Lio/bidmachine/rendering/model/Error;", "error", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/internal/adform/video/player/b;Lio/bidmachine/rendering/model/Error;)V", "a", "c", "g", "h", "e", "i", "", "currentPositionMs", "(Lio/bidmachine/rendering/internal/adform/video/player/b;J)V", "", "volume", "(Lio/bidmachine/rendering/internal/adform/video/player/b;F)V", "", "isMuted", "(Lio/bidmachine/rendering/internal/adform/video/player/b;Z)V", "d", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.adform.video.a$a, reason: collision with other inner class name */
    public final class C0609a implements d {
        public C0609a() {
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b player, Error error) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(error, "error");
            a.this.b(error);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void b(io.bidmachine.rendering.internal.adform.video.player.b player, Error error) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(error, "error");
            a.this.a(error);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void c(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaPaused();
            }
            a.this.o().f();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void d(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaSkipped();
            }
            a.this.o().d();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void e(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaThirdQuartile();
            }
            a.this.o().c();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void f(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onViewReady(player.n());
            }
            a.this.getAdFormListener().b(a.this);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void g(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaStarted(player.g(), player.getVolume());
            }
            a.this.o().j();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void h(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaMidpoint();
            }
            a.this.o().g();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void i(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaCompleted();
            }
            a.this.o().a();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaFirstQuartile();
            }
            a.this.o().i();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void b(io.bidmachine.rendering.internal.adform.video.player.b player) {
            Intrinsics.checkNotNullParameter(player, "player");
            a.this.z();
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaResumed();
            }
            a.this.o().b();
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b player, long currentPositionMs) {
            Intrinsics.checkNotNullParameter(player, "player");
            a.this.o().a(player.g(), currentPositionMs);
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b player, float volume) {
            Intrinsics.checkNotNullParameter(player, "player");
            VideoMeasurer videoMeasurer = a.this.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onMediaVolumeChanged(volume);
            }
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.d
        public void a(io.bidmachine.rendering.internal.adform.video.player.b player, boolean isMuted) {
            Intrinsics.checkNotNullParameter(player, "player");
            View j = a.this.j();
            Integer valueOf = j != null ? Integer.valueOf(j.getId()) : null;
            if (isMuted) {
                a.this.o().b(valueOf);
            } else {
                a.this.o().a(valueOf);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/bidmachine/rendering/internal/adform/video/a$b;", "Lio/bidmachine/rendering/internal/repository/a$a;", "Landroid/net/Uri;", "<init>", "(Lio/bidmachine/rendering/internal/adform/video/a;)V", "uri", "", "a", "(Landroid/net/Uri;)V", "Lio/bidmachine/rendering/model/Error;", "error", "onError", "(Lio/bidmachine/rendering/model/Error;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class b implements a.InterfaceC0625a<Uri> {
        public b() {
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(final Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            final a aVar = a.this;
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.adform.video.a$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.a(a.this, uri);
                }
            });
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        public void onError(Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            a.this.a(error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(a this$0, Uri uri) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(uri, "$uri");
            try {
                io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
                if (bVar != null) {
                    bVar.a(uri);
                    bVar.prepare();
                }
            } catch (Throwable th) {
                o.b(th);
                this$0.a(Error.INSTANCE.create(th));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, io.bidmachine.rendering.internal.repository.a repository, AdElementParams adElementParams, c adFormListener, io.bidmachine.rendering.internal.event.b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a aVar, VideoMeasurer videoMeasurer) {
        super(context, repository, adElementParams, adFormListener, eventCallback, aVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.videoMeasurer = videoMeasurer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        if (bVar != null) {
            bVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        if (bVar != null) {
            bVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final void C() {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda5
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.d(a.this);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.adform.a, io.bidmachine.rendering.internal.InterfaceC3590c
    public void d() {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda8
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.g(a.this);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.w
    public void e() {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda1
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.i(a.this);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.adform.a, io.bidmachine.rendering.internal.InterfaceC3590c
    public void f() {
        super.f();
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda6
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.f(a.this);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.t
    public void k() {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda9
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.h(a.this);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public View v() {
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this.player;
        if (bVar != null) {
            return bVar.n();
        }
        return null;
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public void w() {
        super.w();
        VideoMeasurer videoMeasurer = this.videoMeasurer;
        if (videoMeasurer != null) {
            videoMeasurer.onClicked();
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    protected void x() {
        Unit unit;
        VideoMeasurer videoMeasurer = this.videoMeasurer;
        if (videoMeasurer != null) {
            videoMeasurer.destroy(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda4
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    a.e(a.this);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            C();
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public void z() {
        super.z();
        VideoMeasurer videoMeasurer = this.videoMeasurer;
        if (videoMeasurer != null) {
            videoMeasurer.onShown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        if (bVar != null) {
            bVar.a();
        }
        this$0.player = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void c() {
        Resource resource = getAdElementParams().getResource();
        String str = null;
        ResourceSource source = resource != null ? resource.getSource() : null;
        if (source == null) {
            str = getAdElementParams().getSource();
        } else if (source instanceof UrlResourceSource) {
            str = ((UrlResourceSource) source).getUrl();
        } else {
            b("Invalid resource type (" + source.getClass().getSimpleName() + "), it should be UrlResourceSource");
        }
        MediaSource fromUrl = MediaSource.INSTANCE.fromUrl(str);
        if (fromUrl == null) {
            a(new Error("Invalid adm url (" + str + ')'));
            return;
        }
        final String customParam = fromUrl.getDeliveryType() == MediaSource.DeliveryType.STREAM ? "exo" : getAdElementParams().getCustomParam("player");
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a.a(a.this, customParam);
            }
        });
        getRepository().c(fromUrl, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            io.bidmachine.rendering.internal.adform.video.player.b a2 = io.bidmachine.rendering.internal.adform.video.player.c.a(this$0.getApplicationContext(), str);
            a2.a(this$0.new C0609a());
            VideoMeasurer videoMeasurer = this$0.videoMeasurer;
            if (videoMeasurer != null) {
                videoMeasurer.onViewCreated(a2.n());
            }
            this$0.player = a2;
        } catch (Throwable th) {
            o.b(th);
            this$0.a(Error.INSTANCE.create(th));
        }
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.q
    public void b(final Integer senderId) {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda3
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.a(a.this, senderId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        if (bVar != null) {
            bVar.a(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        if (bVar != null) {
            bVar.pause();
        }
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.g
    public void b() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Error error) {
        VideoMeasurer videoMeasurer = this.videoMeasurer;
        if (videoMeasurer != null) {
            videoMeasurer.onError(error);
        }
        getAdFormListener().a(this, error);
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void a(final ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda2
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.a(a.this, viewGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewGroup, "$viewGroup");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        VideoMeasurer videoMeasurer = this$0.videoMeasurer;
        if (videoMeasurer == null || bVar == null) {
            return;
        }
        videoMeasurer.onViewAddedToContainer(bVar.n(), viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        io.bidmachine.rendering.internal.adform.video.player.b bVar = this$0.player;
        if (bVar != null) {
            bVar.b(num);
        }
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.q
    public void a(final Integer senderId) {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.video.a$$ExternalSyntheticLambda7
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.b(a.this, senderId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Error error) {
        VideoMeasurer videoMeasurer = this.videoMeasurer;
        if (videoMeasurer != null) {
            videoMeasurer.onError(error);
        }
        getAdFormListener().c(this, error);
    }
}
