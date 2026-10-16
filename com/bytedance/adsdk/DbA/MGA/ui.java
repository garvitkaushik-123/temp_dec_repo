package com.bytedance.adsdk.DbA.MGA;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.DbA.Os.DbA.nn;

/* loaded from: classes3.dex */
public class ui {
    private static final PointF eli = new PointF();

    public static boolean Os(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float eli(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int eli(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF eli(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void eli(nn nnVar, Path path) {
        Path path2;
        path.reset();
        PointF eli2 = nnVar.eli();
        path.moveTo(eli2.x, eli2.y);
        eli.set(eli2.x, eli2.y);
        int i = 0;
        while (i < nnVar.Os().size()) {
            com.bytedance.adsdk.DbA.Os.eli eliVar = nnVar.Os().get(i);
            PointF eli3 = eliVar.eli();
            PointF DbA = eliVar.DbA();
            PointF Os = eliVar.Os();
            PointF pointF = eli;
            if (eli3.equals(pointF) && DbA.equals(Os)) {
                path.lineTo(Os.x, Os.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(eli3.x, eli3.y, DbA.x, DbA.y, Os.x, Os.y);
            }
            pointF.set(Os.x, Os.y);
            i++;
            path = path2;
        }
        Path path3 = path;
        if (nnVar.DbA()) {
            path3.close();
        }
    }

    static int eli(float f, float f2) {
        return eli((int) f, (int) f2);
    }

    private static int eli(int i, int i2) {
        return i - (i2 * DbA(i, i2));
    }

    private static int DbA(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int eli(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float DbA(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
