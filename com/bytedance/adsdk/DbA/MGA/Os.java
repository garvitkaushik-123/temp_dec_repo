package com.bytedance.adsdk.DbA.MGA;

import android.view.Choreographer;
import com.bytedance.adsdk.DbA.kb;

/* loaded from: classes3.dex */
public class Os extends eli implements Choreographer.FrameCallback {
    private kb aAs;
    private float DbA = 1.0f;
    private boolean Os = false;
    private long aGH = 0;
    private float ui = 0.0f;
    private float MGA = 0.0f;
    private int kb = 0;
    private float wC = -2.1474836E9f;
    private float FC = 2.1474836E9f;
    protected boolean eli = false;
    private boolean du = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(MGA());
    }

    public float MGA() {
        kb kbVar = this.aAs;
        if (kbVar == null) {
            return 0.0f;
        }
        return (this.MGA - kbVar.MGA()) / (this.aAs.kb() - this.aAs.MGA());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float Dfc;
        float aqO;
        float Dfc2;
        if (this.aAs == null) {
            return 0.0f;
        }
        if (Xb()) {
            Dfc = aqO() - this.MGA;
            aqO = aqO();
            Dfc2 = Dfc();
        } else {
            Dfc = this.MGA - Dfc();
            aqO = aqO();
            Dfc2 = Dfc();
        }
        return Dfc / (aqO - Dfc2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        kb kbVar = this.aAs;
        if (kbVar == null) {
            return 0L;
        }
        return (long) kbVar.ui();
    }

    public float kb() {
        return this.MGA;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.eli;
    }

    public void Os(boolean z) {
        this.du = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        dV();
        if (this.aAs == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.DbA.ui.eli("LottieValueAnimator#doFrame");
        float QX = (this.aGH != 0 ? j - r1 : 0L) / QX();
        float f = this.ui;
        if (Xb()) {
            QX = -QX;
        }
        float f2 = f + QX;
        boolean Os = ui.Os(f2, Dfc(), aqO());
        float f3 = this.ui;
        float DbA = ui.DbA(f2, Dfc(), aqO());
        this.ui = DbA;
        if (this.du) {
            DbA = (float) Math.floor(DbA);
        }
        this.MGA = DbA;
        this.aGH = j;
        if (!this.du || this.ui != f3) {
            Os();
        }
        if (!Os) {
            if (getRepeatCount() != -1 && this.kb >= getRepeatCount()) {
                float Dfc = this.DbA < 0.0f ? Dfc() : aqO();
                this.ui = Dfc;
                this.MGA = Dfc;
                nGm();
                DbA(Xb());
            } else {
                eli();
                this.kb++;
                if (getRepeatMode() == 2) {
                    this.Os = !this.Os;
                    FC();
                } else {
                    float aqO = Xb() ? aqO() : Dfc();
                    this.ui = aqO;
                    this.MGA = aqO;
                }
                this.aGH = j;
            }
        }
        bf();
        com.bytedance.adsdk.DbA.ui.DbA("LottieValueAnimator#doFrame");
    }

    private float QX() {
        kb kbVar = this.aAs;
        if (kbVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / kbVar.nlS()) / Math.abs(this.DbA);
    }

    public void wC() {
        this.aAs = null;
        this.wC = -2.1474836E9f;
        this.FC = 2.1474836E9f;
    }

    public void eli(kb kbVar) {
        boolean z = this.aAs == null;
        this.aAs = kbVar;
        if (z) {
            eli(Math.max(this.wC, kbVar.MGA()), Math.min(this.FC, kbVar.kb()));
        } else {
            eli((int) kbVar.MGA(), (int) kbVar.kb());
        }
        float f = this.MGA;
        this.MGA = 0.0f;
        this.ui = 0.0f;
        eli((int) f);
        Os();
    }

    public void eli(float f) {
        if (this.ui == f) {
            return;
        }
        float DbA = ui.DbA(f, Dfc(), aqO());
        this.ui = DbA;
        if (this.du) {
            DbA = (float) Math.floor(DbA);
        }
        this.MGA = DbA;
        this.aGH = 0L;
        Os();
    }

    public void eli(int i) {
        eli(i, (int) this.FC);
    }

    public void DbA(float f) {
        eli(this.wC, f);
    }

    public void eli(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        kb kbVar = this.aAs;
        float MGA = kbVar == null ? -3.4028235E38f : kbVar.MGA();
        kb kbVar2 = this.aAs;
        float kb = kbVar2 == null ? Float.MAX_VALUE : kbVar2.kb();
        float DbA = ui.DbA(f, MGA, kb);
        float DbA2 = ui.DbA(f2, MGA, kb);
        if (DbA == this.wC && DbA2 == this.FC) {
            return;
        }
        this.wC = DbA;
        this.FC = DbA2;
        eli((int) ui.DbA(this.MGA, DbA, DbA2));
    }

    public void FC() {
        Os(-aAs());
    }

    public void Os(float f) {
        this.DbA = f;
    }

    public float aAs() {
        return this.DbA;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.Os) {
            return;
        }
        this.Os = false;
        FC();
    }

    public void du() {
        this.eli = true;
        eli(Xb());
        eli((int) (Xb() ? aqO() : Dfc()));
        this.aGH = 0L;
        this.kb = 0;
        dV();
    }

    public void nlS() {
        nGm();
        DbA(Xb());
    }

    public void NU() {
        nGm();
        aGH();
    }

    public void nn() {
        this.eli = true;
        dV();
        this.aGH = 0L;
        if (Xb() && kb() == Dfc()) {
            eli(aqO());
        } else if (!Xb() && kb() == aqO()) {
            eli(Dfc());
        }
        ui();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        DbA();
        nGm();
    }

    private boolean Xb() {
        return aAs() < 0.0f;
    }

    public float Dfc() {
        kb kbVar = this.aAs;
        if (kbVar == null) {
            return 0.0f;
        }
        float f = this.wC;
        return f == -2.1474836E9f ? kbVar.MGA() : f;
    }

    public float aqO() {
        kb kbVar = this.aAs;
        if (kbVar == null) {
            return 0.0f;
        }
        float f = this.FC;
        return f == 2.1474836E9f ? kbVar.kb() : f;
    }

    @Override // com.bytedance.adsdk.DbA.MGA.eli
    void DbA() {
        super.DbA();
        DbA(Xb());
    }

    protected void dV() {
        if (isRunning()) {
            aGH(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void nGm() {
        aGH(true);
    }

    protected void aGH(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.eli = false;
        }
    }

    private void bf() {
        if (this.aAs == null) {
            return;
        }
        float f = this.MGA;
        if (f < this.wC || f > this.FC) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.wC), Float.valueOf(this.FC), Float.valueOf(this.MGA)));
        }
    }
}
