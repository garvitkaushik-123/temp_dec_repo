package com.bytedance.adsdk.DbA.Os;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class eli {
    private final PointF DbA;
    private final PointF Os;
    private final PointF eli;

    public eli() {
        this.eli = new PointF();
        this.DbA = new PointF();
        this.Os = new PointF();
    }

    public eli(PointF pointF, PointF pointF2, PointF pointF3) {
        this.eli = pointF;
        this.DbA = pointF2;
        this.Os = pointF3;
    }

    public void eli(float f, float f2) {
        this.eli.set(f, f2);
    }

    public PointF eli() {
        return this.eli;
    }

    public void DbA(float f, float f2) {
        this.DbA.set(f, f2);
    }

    public PointF DbA() {
        return this.DbA;
    }

    public void Os(float f, float f2) {
        this.Os.set(f, f2);
    }

    public PointF Os() {
        return this.Os;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.Os.x), Float.valueOf(this.Os.y), Float.valueOf(this.eli.x), Float.valueOf(this.eli.y), Float.valueOf(this.DbA.x), Float.valueOf(this.DbA.y));
    }
}
