package io.bidmachine.rendering.internal.adform.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.internal.event.b;
import io.bidmachine.rendering.internal.repository.a;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.Base64ResourceSource;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MediaSource;
import io.bidmachine.rendering.model.Resource;
import io.bidmachine.rendering.model.ResourceSource;
import io.bidmachine.rendering.model.UrlResourceSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lio/bidmachine/rendering/internal/adform/image/a;", "Lio/bidmachine/rendering/internal/adform/a;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;)V", "Lio/bidmachine/rendering/model/MediaSource;", "mediaSource", "", "a", "(Lio/bidmachine/rendering/model/MediaSource;)V", "Landroid/view/View;", "v", "()Landroid/view/View;", "c", "()V", "Landroid/widget/ImageView;", "r", "Landroid/widget/ImageView;", "imageView", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a extends io.bidmachine.rendering.internal.adform.a {

    /* renamed from: r, reason: from kotlin metadata */
    private final ImageView imageView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/bidmachine/rendering/internal/adform/image/a$a;", "Lio/bidmachine/rendering/internal/repository/a$a;", "Landroid/graphics/Bitmap;", "<init>", "(Lio/bidmachine/rendering/internal/adform/image/a;)V", "bitmap", "", "a", "(Landroid/graphics/Bitmap;)V", "Lio/bidmachine/rendering/model/Error;", "error", "onError", "(Lio/bidmachine/rendering/model/Error;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.adform.image.a$a, reason: collision with other inner class name */
    private final class C0607a implements a.InterfaceC0625a<Bitmap> {
        public C0607a() {
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            a.this.imageView.setImageBitmap(bitmap);
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        public void onError(Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, io.bidmachine.rendering.internal.repository.a repository, AdElementParams adElementParams, c adFormListener, b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a aVar) {
        super(context, repository, adElementParams, adFormListener, eventCallback, aVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.imageView = new ImageView(context);
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void c() {
        MediaSource.Companion companion = MediaSource.INSTANCE;
        a(companion.fromDefaultSettings(getAdElementParams().getPlaceholder()));
        getAdFormListener().b(this);
        Resource resource = getAdElementParams().getResource();
        ResourceSource source = resource != null ? resource.getSource() : null;
        if (source == null) {
            a(companion.from(getAdElementParams().getSource()));
            return;
        }
        if (source instanceof Base64ResourceSource) {
            a(companion.fromBase64(((Base64ResourceSource) source).getBase64()));
        } else if (source instanceof UrlResourceSource) {
            a(companion.fromUrl(((UrlResourceSource) source).getUrl()));
        } else {
            b("Invalid resource type (" + source.getClass().getSimpleName() + "), it should be Base64ResourceSource or UrlResourceSource");
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public View v() {
        return this.imageView;
    }

    private final void a(MediaSource mediaSource) {
        if (mediaSource != null) {
            getRepository().b(mediaSource, new C0607a());
        }
    }
}
