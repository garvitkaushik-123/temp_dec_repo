package com.bytedance.sdk.openadsdk.core.DbA;

import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.dV;

/* loaded from: classes3.dex */
public class MGA {
    private static float Dfc = 0.0f;
    private static float NU = 0.0f;
    public static int aAs = 8;
    private static float aqO;
    private static long dV;
    private static float nn;
    public float eli = -1.0f;
    public float DbA = -1.0f;
    public float Os = -1.0f;
    public float aGH = -1.0f;
    public long ui = -1;
    public long MGA = -1;
    public int kb = -1;
    public int wC = -1024;
    public int FC = -1;
    public boolean du = true;
    public SparseArray<Os.eli> nlS = new SparseArray<>();
    private int nGm = 0;
    private int QX = 0;

    static {
        if (dV.eli() != null) {
            aAs = dV.DbA();
        }
        NU = 0.0f;
        nn = 0.0f;
        Dfc = 0.0f;
        aqO = 0.0f;
        dV = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.DbA.MGA.aqO <= r3) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(MotionEvent motionEvent) {
        int i;
        this.wC = motionEvent.getDeviceId();
        int i2 = 0;
        this.kb = motionEvent.getToolType(0);
        this.FC = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        int i3 = 1;
        if (actionMasked == 0) {
            this.nGm = (int) motionEvent.getRawX();
            this.QX = (int) motionEvent.getRawY();
            this.eli = motionEvent.getRawX();
            this.DbA = motionEvent.getRawY();
            this.ui = System.currentTimeMillis();
            this.kb = motionEvent.getToolType(0);
            this.wC = motionEvent.getDeviceId();
            this.FC = motionEvent.getSource();
            dV = System.currentTimeMillis();
            this.du = true;
        } else {
            if (actionMasked == 1) {
                this.Os = motionEvent.getRawX();
                this.aGH = motionEvent.getRawY();
                this.MGA = System.currentTimeMillis();
                if (Math.abs(this.Os - this.nGm) >= aAs || Math.abs(this.aGH - this.QX) >= aAs) {
                    this.du = false;
                }
                i = 3;
            } else if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                Dfc += Math.abs(motionEvent.getX() - NU);
                aqO += Math.abs(motionEvent.getY() - nn);
                NU = motionEvent.getX();
                nn = motionEvent.getY();
                if (System.currentTimeMillis() - dV > 200) {
                    float f = Dfc;
                    int i4 = aAs;
                    if (f <= i4) {
                    }
                    this.Os = motionEvent.getRawX();
                    this.aGH = motionEvent.getRawY();
                    if (Math.abs(this.Os - this.nGm) < aAs || Math.abs(this.aGH - this.QX) >= aAs) {
                        this.du = false;
                    }
                    i = i3;
                }
                i3 = 2;
                this.Os = motionEvent.getRawX();
                this.aGH = motionEvent.getRawY();
                if (Math.abs(this.Os - this.nGm) < aAs) {
                }
                this.du = false;
                i = i3;
            }
            this.nlS.put(motionEvent.getActionMasked(), new Os.eli(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        i = i2;
        this.nlS.put(motionEvent.getActionMasked(), new Os.eli(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
    }
}
