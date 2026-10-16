package io.bidmachine.rendering.internal;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 v2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0007\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u001cH\u0016¢\u0006\u0004\b+\u0010\u001eJ\u000f\u0010,\u001a\u00020\u001cH\u0016¢\u0006\u0004\b,\u0010\u001eJ\u000f\u0010-\u001a\u00020\u001cH\u0017¢\u0006\u0004\b-\u0010\u001eJ\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000fH\u0017¢\u0006\u0004\b/\u0010*J\u0015\u0010\f\u001a\u00020\u00002\u0006\u00101\u001a\u000200¢\u0006\u0004\b\f\u00102J-\u0010\u0007\u001a\u00020\u00002\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u0002002\u0006\u00106\u001a\u000200¢\u0006\u0004\b\u0007\u00107J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u00108\u001a\u000200¢\u0006\u0004\b\u0007\u00102J\u0017\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u00109\u001a\u00020\u001c¢\u0006\u0004\b\u0007\u0010:J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b\u0007\u0010=J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b\u0007\u0010@R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010ER\u0014\u0010H\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010K\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010JR\u0014\u0010O\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010ER\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010ER\u0014\u0010W\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010RR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010]\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010ER\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010i\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010l\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010eR\u0016\u0010p\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010hR\u0016\u0010s\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006w"}, d2 = {"Lio/bidmachine/rendering/internal/u;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Bitmap;", "bitmap", "<init>", "(Landroid/graphics/Bitmap;)V", "", "a", "()V", "Landroid/graphics/Canvas;", "canvas", "(Landroid/graphics/Canvas;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "booleans", "", "([Z)Z", "isStateful", "()Z", "", "state", "onStateChange", "([I)Z", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", "draw", "", "getAlpha", "()I", "alpha", "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "getColorFilter", "()Landroid/graphics/ColorFilter;", "cf", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "filter", "setFilterBitmap", "(Z)V", "getIntrinsicWidth", "getIntrinsicHeight", "getOpacity", "dither", "setDither", "", "radius", "(F)Lio/bidmachine/rendering/internal/u;", "topLeft", "topRight", "bottomRight", "bottomLeft", "(FFFF)Lio/bidmachine/rendering/internal/u;", "width", "color", "(I)Lio/bidmachine/rendering/internal/u;", "Landroid/content/res/ColorStateList;", "colors", "(Landroid/content/res/ColorStateList;)Lio/bidmachine/rendering/internal/u;", "Landroid/widget/ImageView$ScaleType;", "scaleType", "(Landroid/widget/ImageView$ScaleType;)Lio/bidmachine/rendering/internal/u;", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "boundRect", "c", "drawableRect", "d", "I", "bitmapWidth", "e", "bitmapHeight", InneractiveMediationDefs.GENDER_FEMALE, "bitmapRect", "Landroid/graphics/Paint;", "g", "Landroid/graphics/Paint;", "bitmapPaint", "h", "borderRect", "i", "borderPaint", "Landroid/graphics/Matrix;", com.mbridge.msdk.foundation.same.report.j.b, "Landroid/graphics/Matrix;", "shaderMatrix", CampaignEx.JSON_KEY_AD_K, "squareCornersRect", "Landroid/graphics/Shader$TileMode;", "l", "Landroid/graphics/Shader$TileMode;", "tileModeX", "m", "tileModeY", D5.q, "Z", "rebuildShader", "o", "F", "cornerRadius", "p", "[Z", "cornersRounded", CampaignEx.JSON_KEY_AD_Q, "oval", "r", "borderWidth", "s", "Landroid/content/res/ColorStateList;", "borderColor", "t", "Landroid/widget/ImageView$ScaleType;", "u", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class u extends Drawable {
    private static final ImageView.ScaleType v = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Bitmap bitmap;

    /* renamed from: b, reason: from kotlin metadata */
    private final RectF boundRect;

    /* renamed from: c, reason: from kotlin metadata */
    private final RectF drawableRect;

    /* renamed from: d, reason: from kotlin metadata */
    private final int bitmapWidth;

    /* renamed from: e, reason: from kotlin metadata */
    private final int bitmapHeight;

    /* renamed from: f, reason: from kotlin metadata */
    private final RectF bitmapRect;

    /* renamed from: g, reason: from kotlin metadata */
    private final Paint bitmapPaint;

    /* renamed from: h, reason: from kotlin metadata */
    private final RectF borderRect;

    /* renamed from: i, reason: from kotlin metadata */
    private final Paint borderPaint;

    /* renamed from: j, reason: from kotlin metadata */
    private final Matrix shaderMatrix;

    /* renamed from: k, reason: from kotlin metadata */
    private final RectF squareCornersRect;

    /* renamed from: l, reason: from kotlin metadata */
    private Shader.TileMode tileModeX;

    /* renamed from: m, reason: from kotlin metadata */
    private Shader.TileMode tileModeY;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean rebuildShader;

    /* renamed from: o, reason: from kotlin metadata */
    private float cornerRadius;

    /* renamed from: p, reason: from kotlin metadata */
    private final boolean[] cornersRounded;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean oval;

    /* renamed from: r, reason: from kotlin metadata */
    private float borderWidth;

    /* renamed from: s, reason: from kotlin metadata */
    private ColorStateList borderColor;

    /* renamed from: t, reason: from kotlin metadata */
    private ImageView.ScaleType scaleType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public u(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.boundRect = new RectF();
        this.drawableRect = new RectF();
        int width = bitmap.getWidth();
        this.bitmapWidth = width;
        int height = bitmap.getHeight();
        this.bitmapHeight = height;
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, width, height);
        this.bitmapRect = rectF;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.bitmapPaint = paint;
        this.borderRect = new RectF();
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.borderPaint = paint2;
        this.shaderMatrix = new Matrix();
        this.squareCornersRect = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.tileModeX = tileMode;
        this.tileModeY = tileMode;
        this.rebuildShader = true;
        this.cornersRounded = new boolean[]{true, true, true, true};
        ColorStateList valueOf = ColorStateList.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(DEFAULT_BORDER_COLOR)");
        this.borderColor = valueOf;
        this.scaleType = v;
        paint2.setColor(valueOf.getColorForState(getState(), 0));
        paint2.setStrokeWidth(this.borderWidth);
    }

    private final void a() {
        float width;
        float f;
        switch (b.$EnumSwitchMapping$0[this.scaleType.ordinal()]) {
            case 1:
                this.borderRect.set(this.boundRect);
                RectF rectF = this.borderRect;
                float f2 = this.borderWidth / 2;
                rectF.inset(f2, f2);
                this.shaderMatrix.reset();
                this.shaderMatrix.setTranslate(((this.borderRect.width() - this.bitmapWidth) * 0.5f) + 0.5f, ((this.borderRect.height() - this.bitmapHeight) * 0.5f) + 0.5f);
                break;
            case 2:
                this.borderRect.set(this.boundRect);
                RectF rectF2 = this.borderRect;
                float f3 = 2;
                float f4 = this.borderWidth / f3;
                rectF2.inset(f4, f4);
                this.shaderMatrix.reset();
                float f5 = 0.0f;
                if (this.bitmapWidth * this.borderRect.height() > this.borderRect.width() * this.bitmapHeight) {
                    width = this.borderRect.height() / this.bitmapHeight;
                    f = (this.borderRect.width() - (this.bitmapWidth * width)) * 0.5f;
                } else {
                    width = this.borderRect.width() / this.bitmapWidth;
                    f = 0.0f;
                    f5 = (this.borderRect.height() - (this.bitmapHeight * width)) * 0.5f;
                }
                this.shaderMatrix.setScale(width, width);
                Matrix matrix = this.shaderMatrix;
                float f6 = this.borderWidth / f3;
                matrix.postTranslate(((int) (f + 0.5f)) + f6, ((int) (f5 + 0.5f)) + f6);
                break;
            case 3:
                this.shaderMatrix.reset();
                float min = (((float) this.bitmapWidth) > this.boundRect.width() || ((float) this.bitmapHeight) > this.boundRect.height()) ? Math.min(this.boundRect.width() / this.bitmapWidth, this.boundRect.height() / this.bitmapHeight) : 1.0f;
                float width2 = ((this.boundRect.width() - (this.bitmapWidth * min)) * 0.5f) + 0.5f;
                float height = ((this.boundRect.height() - (this.bitmapHeight * min)) * 0.5f) + 0.5f;
                this.shaderMatrix.setScale(min, min);
                this.shaderMatrix.postTranslate(width2, height);
                this.borderRect.set(this.bitmapRect);
                this.shaderMatrix.mapRect(this.borderRect);
                RectF rectF3 = this.borderRect;
                float f7 = this.borderWidth / 2;
                rectF3.inset(f7, f7);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.borderRect, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.borderRect.set(this.bitmapRect);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.boundRect, Matrix.ScaleToFit.CENTER);
                this.shaderMatrix.mapRect(this.borderRect);
                RectF rectF4 = this.borderRect;
                float f8 = this.borderWidth / 2;
                rectF4.inset(f8, f8);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.borderRect, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.borderRect.set(this.bitmapRect);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.boundRect, Matrix.ScaleToFit.END);
                this.shaderMatrix.mapRect(this.borderRect);
                RectF rectF5 = this.borderRect;
                float f9 = this.borderWidth / 2;
                rectF5.inset(f9, f9);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.borderRect, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.borderRect.set(this.bitmapRect);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.boundRect, Matrix.ScaleToFit.START);
                this.shaderMatrix.mapRect(this.borderRect);
                RectF rectF6 = this.borderRect;
                float f10 = this.borderWidth / 2;
                rectF6.inset(f10, f10);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.borderRect, Matrix.ScaleToFit.FILL);
                break;
            case 7:
                this.borderRect.set(this.boundRect);
                RectF rectF7 = this.borderRect;
                float f11 = this.borderWidth / 2;
                rectF7.inset(f11, f11);
                this.shaderMatrix.reset();
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.borderRect, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.borderRect.set(this.bitmapRect);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.boundRect, Matrix.ScaleToFit.CENTER);
                this.shaderMatrix.mapRect(this.borderRect);
                RectF rectF8 = this.borderRect;
                float f12 = this.borderWidth / 2;
                rectF8.inset(f12, f12);
                this.shaderMatrix.setRectToRect(this.bitmapRect, this.borderRect, Matrix.ScaleToFit.FILL);
                break;
        }
        this.drawableRect.set(this.borderRect);
        this.rebuildShader = true;
    }

    private final void b(Canvas canvas) {
        float f;
        float f2;
        if (a(this.cornersRounded) || this.cornerRadius == 0.0f) {
            return;
        }
        RectF rectF = this.drawableRect;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float width = rectF.width() + f3;
        float height = f4 + this.drawableRect.height();
        float f5 = this.cornerRadius;
        float f6 = this.borderWidth / 2;
        if (this.cornersRounded[0]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine(f3 - f6, f4, f3 + f5, f, this.borderPaint);
            canvas.drawLine(f3, f - f6, f3, f + f5, this.borderPaint);
        }
        if (!this.cornersRounded[1]) {
            float f7 = f;
            canvas.drawLine((width - f5) - f6, f7, width, f, this.borderPaint);
            canvas.drawLine(width, f7 - f6, width, f7 + f5, this.borderPaint);
            width = width;
        }
        if (this.cornersRounded[2]) {
            f2 = height;
        } else {
            canvas.drawLine((width - f5) - f6, height, width + f6, height, this.borderPaint);
            canvas.drawLine(width, height - f5, width, height, this.borderPaint);
            f2 = height;
        }
        if (this.cornersRounded[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, f2, f3 + f5, f2, this.borderPaint);
        canvas.drawLine(f3, f2 - f5, f3, f2, this.borderPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.rebuildShader) {
            BitmapShader bitmapShader = new BitmapShader(this.bitmap, this.tileModeX, this.tileModeY);
            Shader.TileMode tileMode = this.tileModeX;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.tileModeY == tileMode2) {
                bitmapShader.setLocalMatrix(this.shaderMatrix);
            }
            this.bitmapPaint.setShader(bitmapShader);
            this.rebuildShader = false;
        }
        if (this.oval) {
            if (this.borderWidth <= 0.0f) {
                canvas.drawOval(this.drawableRect, this.bitmapPaint);
                return;
            } else {
                canvas.drawOval(this.drawableRect, this.bitmapPaint);
                canvas.drawOval(this.borderRect, this.borderPaint);
                return;
            }
        }
        if (!b(this.cornersRounded)) {
            canvas.drawRect(this.drawableRect, this.bitmapPaint);
            if (this.borderWidth > 0.0f) {
                canvas.drawRect(this.borderRect, this.borderPaint);
                return;
            }
            return;
        }
        float f = this.cornerRadius;
        if (this.borderWidth <= 0.0f) {
            canvas.drawRoundRect(this.drawableRect, f, f, this.bitmapPaint);
            a(canvas);
        } else {
            canvas.drawRoundRect(this.drawableRect, f, f, this.bitmapPaint);
            canvas.drawRoundRect(this.borderRect, f, f, this.borderPaint);
            a(canvas);
            b(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.bitmapPaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.bitmapPaint.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.bitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.bitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.borderColor.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.boundRect.set(bounds);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int colorForState = this.borderColor.getColorForState(state, 0);
        if (this.borderPaint.getColor() == colorForState) {
            return super.onStateChange(state);
        }
        this.borderPaint.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.bitmapPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.bitmapPaint.setColorFilter(cf);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public void setDither(boolean dither) {
        this.bitmapPaint.setDither(dither);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        this.bitmapPaint.setFilterBitmap(filter);
        invalidateSelf();
    }

    public final u b(float radius) {
        a(radius, radius, radius, radius);
        return this;
    }

    private final boolean b(boolean[] booleans) {
        for (boolean z : booleans) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private final void a(Canvas canvas) {
        if (a(this.cornersRounded) || this.cornerRadius == 0.0f) {
            return;
        }
        RectF rectF = this.drawableRect;
        float f = rectF.left;
        float f2 = rectF.top;
        float width = rectF.width() + f;
        float height = this.drawableRect.height() + f2;
        float f3 = this.cornerRadius;
        if (!this.cornersRounded[0]) {
            this.squareCornersRect.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.squareCornersRect, this.bitmapPaint);
        }
        if (!this.cornersRounded[1]) {
            this.squareCornersRect.set(width - f3, f2, width, f3);
            canvas.drawRect(this.squareCornersRect, this.bitmapPaint);
        }
        if (!this.cornersRounded[2]) {
            this.squareCornersRect.set(width - f3, height - f3, width, height);
            canvas.drawRect(this.squareCornersRect, this.bitmapPaint);
        }
        if (this.cornersRounded[3]) {
            return;
        }
        this.squareCornersRect.set(f, height - f3, f3 + f, height);
        canvas.drawRect(this.squareCornersRect, this.bitmapPaint);
    }

    public final u a(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(topLeft));
        hashSet.add(Float.valueOf(topRight));
        hashSet.add(Float.valueOf(bottomRight));
        hashSet.add(Float.valueOf(bottomLeft));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Number) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.cornerRadius = floatValue;
                }
            } else {
                this.cornerRadius = 0.0f;
            }
            boolean[] zArr = this.cornersRounded;
            zArr[0] = topLeft > 0.0f;
            zArr[1] = topRight > 0.0f;
            zArr[2] = bottomRight > 0.0f;
            zArr[3] = bottomLeft > 0.0f;
            return this;
        }
        return this;
    }

    public final u a(float width) {
        this.borderWidth = width;
        this.borderPaint.setStrokeWidth(width);
        return this;
    }

    public final u a(int color) {
        return a(ColorStateList.valueOf(color));
    }

    public final u a(ColorStateList colors) {
        if (colors == null) {
            colors = ColorStateList.valueOf(0);
            Intrinsics.checkNotNullExpressionValue(colors, "valueOf(0)");
        }
        this.borderColor = colors;
        this.borderPaint.setColor(colors.getColorForState(getState(), 0));
        return this;
    }

    public final u a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = v;
        }
        if (this.scaleType != scaleType) {
            this.scaleType = scaleType;
            a();
        }
        return this;
    }

    private final boolean a(boolean[] booleans) {
        for (boolean z : booleans) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
