package io.bidmachine.iab.mraid;

import android.content.Context;
import android.graphics.Rect;
import io.bidmachine.iab.utils.Utils;

/* loaded from: classes7.dex */
public class MraidScreenMetrics {

    /* renamed from: a, reason: collision with root package name */
    private final float f6817a;
    private final Rect b = new Rect();
    private final Rect c = new Rect();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();

    public MraidScreenMetrics(Context context) {
        this.f6817a = context.getResources().getDisplayMetrics().density;
    }

    boolean a(int width, int height) {
        if (this.b.width() == width && this.b.height() == height) {
            return false;
        }
        this.b.set(0, 0, width, height);
        a(this.b, this.c);
        return true;
    }

    Rect b() {
        return this.h;
    }

    boolean c(int x, int y, int width, int height) {
        return a(this.d, this.e, x, y, width, height);
    }

    Rect d() {
        return this.e;
    }

    Rect e() {
        return this.c;
    }

    public float getDensity() {
        return this.f6817a;
    }

    boolean b(int x, int y, int width, int height) {
        return a(this.h, this.i, x, y, width, height);
    }

    Rect c() {
        return this.i;
    }

    Rect a() {
        return this.g;
    }

    boolean a(int x, int y, int width, int height) {
        return a(this.f, this.g, x, y, width, height);
    }

    private boolean a(Rect rect, Rect rectDips, int x, int y, int width, int height) {
        if (rect.left == x && rect.top == y && x + width == rect.right && y + height == rect.bottom) {
            return false;
        }
        rect.set(x, y, width + x, height + y);
        a(rect, rectDips);
        return true;
    }

    void a(Rect sourceRect, Rect outRect) {
        outRect.set(Utils.pixelsToIntDips(sourceRect.left, this.f6817a), Utils.pixelsToIntDips(sourceRect.top, this.f6817a), Utils.pixelsToIntDips(sourceRect.right, this.f6817a), Utils.pixelsToIntDips(sourceRect.bottom, this.f6817a));
    }
}
