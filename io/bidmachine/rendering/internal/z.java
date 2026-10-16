package io.bidmachine.rendering.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.compose.material.OutlinedTextFieldKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.repository.a;
import io.bidmachine.rendering.model.Background;
import io.bidmachine.rendering.model.BackgroundSource;
import io.bidmachine.rendering.model.Base64ResourceSource;
import io.bidmachine.rendering.model.Border;
import io.bidmachine.rendering.model.Color;
import io.bidmachine.rendering.model.ColorBackgroundSource;
import io.bidmachine.rendering.model.ColorPlaceholderSource;
import io.bidmachine.rendering.model.ColorSource;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.Gradient;
import io.bidmachine.rendering.model.GradientColorSource;
import io.bidmachine.rendering.model.GradientType;
import io.bidmachine.rendering.model.HtmlResourceSource;
import io.bidmachine.rendering.model.Image;
import io.bidmachine.rendering.model.ImageBackgroundSource;
import io.bidmachine.rendering.model.ImagePlaceholderSource;
import io.bidmachine.rendering.model.MediaSource;
import io.bidmachine.rendering.model.NamePlaceholderSource;
import io.bidmachine.rendering.model.OneColorSource;
import io.bidmachine.rendering.model.Placeholder;
import io.bidmachine.rendering.model.PlaceholderSource;
import io.bidmachine.rendering.model.ResourceSource;
import io.bidmachine.rendering.model.ScaleType;
import io.bidmachine.rendering.model.ScaleTypeKt;
import io.bidmachine.rendering.model.UrlResourceSource;
import io.bidmachine.rendering.model.XmlResourceSource;
import io.bidmachine.util.UtilsKt;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0017J?\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0018J?\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u001bJ?\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u001eJM\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0011\u0010#J'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b\u0011\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lio/bidmachine/rendering/internal/z;", "", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/Background;", "background", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/Background;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "cornerRadiusPx", "Lio/bidmachine/rendering/model/Border;", OutlinedTextFieldKt.BorderId, "", "a", "(Landroid/view/View;Ljava/lang/Integer;Lio/bidmachine/rendering/model/Border;)V", "", "isMainBackground", "Lio/bidmachine/rendering/model/Color;", "color", "(Landroid/view/View;ZLio/bidmachine/rendering/model/Color;Ljava/lang/Integer;Lio/bidmachine/rendering/model/Border;)V", "(Landroid/view/View;ZILjava/lang/Integer;Lio/bidmachine/rendering/model/Border;)V", "Lio/bidmachine/rendering/model/Gradient;", "gradient", "(Landroid/view/View;ZLio/bidmachine/rendering/model/Gradient;Ljava/lang/Integer;Lio/bidmachine/rendering/model/Border;)V", "Lio/bidmachine/rendering/model/Image;", "image", "(Landroid/view/View;ZLio/bidmachine/rendering/model/Image;Ljava/lang/Integer;Lio/bidmachine/rendering/model/Border;)V", "Landroid/graphics/Bitmap;", "bitmap", "Lio/bidmachine/rendering/model/ScaleType;", "scaleType", "(Landroid/view/View;ZLandroid/graphics/Bitmap;Lio/bidmachine/rendering/model/ScaleType;Ljava/lang/Integer;Lio/bidmachine/rendering/model/Border;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/view/View;ZLandroid/graphics/drawable/Drawable;)V", "Landroid/content/Context;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/internal/repository/a;", "c", "Lio/bidmachine/rendering/model/Background;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isMainBackgroundSet", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.repository.a repository;

    /* renamed from: c, reason: from kotlin metadata */
    private final Background background;

    /* renamed from: d, reason: from kotlin metadata */
    private final AtomicBoolean isMainBackgroundSet;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lio/bidmachine/rendering/internal/z$a;", "Lio/bidmachine/rendering/internal/repository/a$a;", "Landroid/graphics/Bitmap;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "isMainBackground", "Lio/bidmachine/rendering/model/ScaleType;", "scaleType", "", "cornerRadiusPx", "Lio/bidmachine/rendering/model/Border;", OutlinedTextFieldKt.BorderId, "<init>", "(Lio/bidmachine/rendering/internal/z;Landroid/view/View;ZLio/bidmachine/rendering/model/ScaleType;Ljava/lang/Integer;Lio/bidmachine/rendering/model/Border;)V", "successType", "", "a", "(Landroid/graphics/Bitmap;)V", "Lio/bidmachine/rendering/model/Error;", "error", "onError", "(Lio/bidmachine/rendering/model/Error;)V", "Z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/model/ScaleType;", "c", "Ljava/lang/Integer;", "d", "Lio/bidmachine/rendering/model/Border;", "Ljava/lang/ref/WeakReference;", "e", "Ljava/lang/ref/WeakReference;", "weakView", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a implements a.InterfaceC0625a<Bitmap> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isMainBackground;

        /* renamed from: b, reason: from kotlin metadata */
        private final ScaleType scaleType;

        /* renamed from: c, reason: from kotlin metadata */
        private final Integer cornerRadiusPx;

        /* renamed from: d, reason: from kotlin metadata */
        private final Border border;

        /* renamed from: e, reason: from kotlin metadata */
        private final WeakReference<View> weakView;
        final /* synthetic */ z f;

        public a(z zVar, View view, boolean z, ScaleType scaleType, Integer num, Border border) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f = zVar;
            this.isMainBackground = z;
            this.scaleType = scaleType;
            this.cornerRadiusPx = num;
            this.border = border;
            this.weakView = new WeakReference<>(view);
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Bitmap successType) {
            Intrinsics.checkNotNullParameter(successType, "successType");
            z zVar = this.f;
            try {
                View view = this.weakView.get();
                if (view == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(view, "weakView.get() ?: return");
                zVar.a(view, this.isMainBackground, successType, this.scaleType, this.cornerRadiusPx, this.border);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        public void onError(Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }
    }

    public z(Context context, io.bidmachine.rendering.internal.repository.a repository, Background background) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(background, "background");
        this.context = context;
        this.repository = repository;
        this.background = background;
        this.isMainBackgroundSet = new AtomicBoolean(false);
    }

    public static /* synthetic */ void a(z zVar, View view, Integer num, Border border, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            border = null;
        }
        zVar.a(view, num, border);
    }

    public final void a(View view, Integer cornerRadiusPx, Border border) {
        Intrinsics.checkNotNullParameter(view, "view");
        Placeholder placeholder = this.background.getPlaceholder();
        if (placeholder != null) {
            try {
                PlaceholderSource source = placeholder.getSource();
                if (source instanceof NamePlaceholderSource) {
                    a(this, view, false, i.f7072a.c(((NamePlaceholderSource) source).getName()), null, cornerRadiusPx, border, 8, null);
                } else if (source instanceof ColorPlaceholderSource) {
                    a(view, false, ((ColorPlaceholderSource) source).getColor(), cornerRadiusPx, border);
                } else if (source instanceof ImagePlaceholderSource) {
                    a(view, false, ((ImagePlaceholderSource) source).getImage(), cornerRadiusPx, border);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
        }
        BackgroundSource source2 = this.background.getSource();
        if (source2 != null) {
            try {
                if (source2 instanceof ColorBackgroundSource) {
                    a(view, true, ((ColorBackgroundSource) source2).getColor(), cornerRadiusPx, border);
                } else if (source2 instanceof ImageBackgroundSource) {
                    a(view, true, ((ImageBackgroundSource) source2).getImage(), cornerRadiusPx, border);
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable unused2) {
            }
        }
    }

    public final void a(View view, boolean isMainBackground, Color color, Integer cornerRadiusPx, Border border) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(color, "color");
        ColorSource source = color.getSource();
        if (source instanceof OneColorSource) {
            a(view, isMainBackground, ((OneColorSource) source).getColor(), cornerRadiusPx, border);
        } else if (source instanceof GradientColorSource) {
            a(view, isMainBackground, ((GradientColorSource) source).getGradient(), cornerRadiusPx, border);
        }
    }

    public final void a(View view, boolean isMainBackground, int color, Integer cornerRadiusPx, Border border) {
        Intrinsics.checkNotNullParameter(view, "view");
        j jVar = new j();
        jVar.b(color);
        if (cornerRadiusPx != null) {
            jVar.a(cornerRadiusPx.intValue());
        }
        if (border != null) {
            j.a(jVar, border.getStrokeWidthPx(), border.getStrokeColor(), 0.0f, 0.0f, 12, null);
            view.setPadding(border.getStrokeWidthPx(), border.getStrokeWidthPx() - UtilsKt.dpToPx(this.context, 2.0f), border.getStrokeWidthPx(), border.getStrokeWidthPx() + UtilsKt.dpToPx(this.context, 2.0f));
        }
        a(view, isMainBackground, jVar);
    }

    public final void a(View view, boolean isMainBackground, Gradient gradient, Integer cornerRadiusPx, Border border) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(gradient, "gradient");
        int drawableGradientType = gradient.getType().toDrawableGradientType();
        j jVar = new j(gradient.getDirection().toDrawableGradientOrientation(), CollectionsKt.toIntArray(gradient.getColors()));
        jVar.c(drawableGradientType);
        if (gradient.getType() == GradientType.Radial) {
            j.a(jVar, 0.0f, 2, 1, null);
        }
        if (cornerRadiusPx != null) {
            jVar.a(cornerRadiusPx.intValue());
        }
        if (border != null) {
            j.a(jVar, border.getStrokeWidthPx(), border.getStrokeColor(), 0.0f, 0.0f, 12, null);
            view.setPadding(border.getStrokeWidthPx(), border.getStrokeWidthPx() - UtilsKt.dpToPx(this.context, 2.0f), border.getStrokeWidthPx(), border.getStrokeWidthPx() + UtilsKt.dpToPx(this.context, 2.0f));
        }
        a(view, isMainBackground, jVar);
    }

    public final void a(View view, boolean isMainBackground, Image image, Integer cornerRadiusPx, Border border) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(image, "image");
        ResourceSource source = image.getResource().getSource();
        if (source instanceof Base64ResourceSource) {
            a(view, isMainBackground, i.b(((Base64ResourceSource) source).getBase64()), image.getScaleType(), cornerRadiusPx, border);
            return;
        }
        if (source instanceof UrlResourceSource) {
            MediaSource fromUrl = MediaSource.INSTANCE.fromUrl(((UrlResourceSource) source).getUrl());
            if (fromUrl != null) {
                this.repository.b(fromUrl, new a(this, view, isMainBackground, image.getScaleType(), cornerRadiusPx, border));
                return;
            }
            return;
        }
        if (source instanceof HtmlResourceSource) {
            return;
        }
        boolean z = source instanceof XmlResourceSource;
    }

    public static /* synthetic */ void a(z zVar, View view, boolean z, Bitmap bitmap, ScaleType scaleType, Integer num, Border border, int i, Object obj) {
        if ((i & 8) != 0) {
            scaleType = null;
        }
        if ((i & 16) != 0) {
            num = null;
        }
        if ((i & 32) != 0) {
            border = null;
        }
        zVar.a(view, z, bitmap, scaleType, num, border);
    }

    public final void a(View view, boolean isMainBackground, Bitmap bitmap, ScaleType scaleType, Integer cornerRadiusPx, Border border) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (bitmap == null) {
            return;
        }
        ImageView.ScaleType imageViewScaleType = ScaleTypeKt.toImageViewScaleType(scaleType);
        u uVar = new u(bitmap);
        uVar.a(imageViewScaleType);
        if (cornerRadiusPx != null && cornerRadiusPx.intValue() > 0) {
            uVar.b(cornerRadiusPx.intValue());
        }
        if (border != null) {
            uVar.a(border.getStrokeWidthPx());
            uVar.a(border.getStrokeColor());
            view.setPadding(border.getStrokeWidthPx(), border.getStrokeWidthPx() - UtilsKt.dpToPx(this.context, 2.0f), border.getStrokeWidthPx(), border.getStrokeWidthPx() + UtilsKt.dpToPx(this.context, 2.0f));
        }
        a(view, isMainBackground, uVar);
    }

    public final void a(View view, boolean isMainBackground, Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.isMainBackgroundSet.compareAndSet(false, isMainBackground)) {
            drawable.setAlpha((int) UtilsKt.fromRatio(Float.valueOf(this.background.getIo.bidmachine.iab.vast.tags.VastAttributes.OPACITY java.lang.String()), 255.0f));
            drawable.setBounds(0, 0, view.getWidth(), view.getHeight());
            view.setBackground(drawable);
        }
    }
}
