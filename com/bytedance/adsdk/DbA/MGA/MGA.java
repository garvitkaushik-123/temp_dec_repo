package com.bytedance.adsdk.DbA.MGA;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import com.bytedance.adsdk.DbA.eli.eli.bf;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* loaded from: classes3.dex */
public final class MGA {
    private static final ThreadLocal<PathMeasure> eli = new ThreadLocal<PathMeasure>() { // from class: com.bytedance.adsdk.DbA.MGA.MGA.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> DbA = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.DbA.MGA.MGA.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> Os = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.DbA.MGA.MGA.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<float[]> aGH = new ThreadLocal<float[]>() { // from class: com.bytedance.adsdk.DbA.MGA.MGA.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float ui = (float) (Math.sqrt(2.0d) / 2.0d);

    public static int eli(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (f * 527.0f) : 17;
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        return f4 != 0.0f ? (int) (i * 31 * f4) : i;
    }

    public static boolean eli(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    public static Path eli(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
            return path;
        }
        path.lineTo(pointF2.x, pointF2.y);
        return path;
    }

    public static void eli(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float eli(Matrix matrix) {
        float[] fArr = aGH.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = ui;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean DbA(Matrix matrix) {
        float[] fArr = aGH.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static void eli(Path path, bf bfVar) {
        if (bfVar == null || bfVar.MGA()) {
            return;
        }
        eli(path, ((com.bytedance.adsdk.DbA.eli.DbA.aGH) bfVar.Os()).FC() / 100.0f, ((com.bytedance.adsdk.DbA.eli.DbA.aGH) bfVar.aGH()).FC() / 100.0f, ((com.bytedance.adsdk.DbA.eli.DbA.aGH) bfVar.ui()).FC() / 360.0f);
    }

    public static void eli(Path path, float f, float f2, float f3) {
        com.bytedance.adsdk.DbA.ui.eli("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = eli.get();
        Path path2 = DbA.get();
        Path path3 = Os.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.bytedance.adsdk.DbA.ui.DbA("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.bytedance.adsdk.DbA.ui.DbA("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float min = Math.min(f4, f5) + f6;
        float max = Math.max(f4, f5) + f6;
        if (min >= length && max >= length) {
            min = ui.eli(min, length);
            max = ui.eli(max, length);
        }
        if (min < 0.0f) {
            min = ui.eli(min, length);
        }
        if (max < 0.0f) {
            max = ui.eli(max, length);
        }
        if (min == max) {
            path.reset();
            com.bytedance.adsdk.DbA.ui.DbA("applyTrimPathIfNeeded");
            return;
        }
        if (min >= max) {
            min -= length;
        }
        path2.reset();
        pathMeasure.getSegment(min, max, path2, true);
        if (max > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, max % length, path3, true);
            path2.addPath(path3);
        } else if (min < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(min + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        com.bytedance.adsdk.DbA.ui.DbA("applyTrimPathIfNeeded");
    }

    public static float eli() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float eli(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap eli(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean eli(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void eli(Canvas canvas, RectF rectF, Paint paint) {
        eli(canvas, rectF, paint, 31);
    }

    public static void eli(Canvas canvas, RectF rectF, Paint paint, int i) {
        com.bytedance.adsdk.DbA.ui.eli("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        com.bytedance.adsdk.DbA.ui.DbA("Utils#saveLayer");
    }
}
