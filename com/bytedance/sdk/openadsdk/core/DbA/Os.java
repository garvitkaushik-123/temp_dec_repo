package com.bytedance.sdk.openadsdk.core.DbA;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.settings.FC;

/* loaded from: classes3.dex */
public abstract class Os implements View.OnClickListener, View.OnTouchListener {
    private static float DbA = 0.0f;
    protected static int GB = 8;
    private static float Os;
    private static float aGH;
    private static float eli;
    private static long ui;
    protected View qj;
    protected float bf = -1.0f;
    protected float CMM = -1.0f;
    protected float ev = -1.0f;
    protected float Vy = -1.0f;
    protected long gG = -1;
    protected long ujq = -1;
    protected int Ue = -1;
    protected int KM = -1024;
    protected int VM = -1;
    protected boolean oWW = true;
    public SparseArray<eli> nro = new SparseArray<>();
    private int MGA = 0;
    private int kb = 0;

    protected abstract void eli(View view, float f, float f2, float f3, float f4, SparseArray<eli> sparseArray, boolean z);

    static {
        if (dV.eli() != null) {
            GB = dV.DbA();
        }
        eli = 0.0f;
        DbA = 0.0f;
        Os = 0.0f;
        aGH = 0.0f;
        ui = 0L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (FC.eli()) {
            eli(view, this.bf, this.CMM, this.ev, this.Vy, this.nro, this.oWW);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.DbA.Os.aGH <= r3) goto L19;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        this.KM = motionEvent.getDeviceId();
        this.Ue = motionEvent.getToolType(0);
        this.VM = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 1;
        if (actionMasked != 0) {
            int i3 = 3;
            if (actionMasked == 1) {
                this.ev = motionEvent.getRawX();
                this.Vy = motionEvent.getRawY();
                this.ujq = System.currentTimeMillis();
                if (Math.abs(this.ev - this.MGA) >= GB || Math.abs(this.Vy - this.kb) >= GB) {
                    this.oWW = false;
                }
                Point point = new Point((int) this.ev, (int) this.Vy);
                if (view != null && !DbA.Os(view) && eli((View) view.getParent(), point)) {
                    return true;
                }
            } else if (actionMasked != 2) {
                i3 = actionMasked != 3 ? -1 : 4;
            } else {
                Os += Math.abs(motionEvent.getX() - eli);
                aGH += Math.abs(motionEvent.getY() - DbA);
                eli = motionEvent.getX();
                DbA = motionEvent.getY();
                if (System.currentTimeMillis() - ui > 200) {
                    float f = Os;
                    int i4 = GB;
                    if (f <= i4) {
                    }
                    this.ev = motionEvent.getRawX();
                    this.Vy = motionEvent.getRawY();
                    if (Math.abs(this.ev - this.MGA) < GB || Math.abs(this.Vy - this.kb) >= GB) {
                        this.oWW = false;
                    }
                    i = i2;
                }
                i2 = 2;
                this.ev = motionEvent.getRawX();
                this.Vy = motionEvent.getRawY();
                if (Math.abs(this.ev - this.MGA) < GB) {
                }
                this.oWW = false;
                i = i2;
            }
            i = i3;
        } else {
            this.MGA = (int) motionEvent.getRawX();
            this.kb = (int) motionEvent.getRawY();
            this.bf = motionEvent.getRawX();
            this.CMM = motionEvent.getRawY();
            this.gG = System.currentTimeMillis();
            this.Ue = motionEvent.getToolType(0);
            this.KM = motionEvent.getDeviceId();
            this.VM = motionEvent.getSource();
            ui = System.currentTimeMillis();
            this.oWW = true;
            this.qj = view;
            com.bytedance.sdk.openadsdk.core.FC.Os.eli(motionEvent);
            i = 0;
        }
        this.nro.put(motionEvent.getActionMasked(), new eli(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    private boolean eli(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DbA.Os(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && point.x >= iArr[0] && point.x <= iArr[0] + childAt.getWidth() && point.y >= iArr[1] && point.y <= iArr[1] + childAt.getHeight();
                }
                if (eli(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class eli {
        public double DbA;
        public double Os;
        public long aGH;
        public int eli;

        public eli(int i, double d, double d2, long j) {
            this.eli = i;
            this.DbA = d;
            this.Os = d2;
            this.aGH = j;
        }
    }

    public boolean kb() {
        return this.oWW;
    }
}
