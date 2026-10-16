package com.bytedance.adsdk.DbA;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.DbA.ui.CMM;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class FC extends Drawable implements Animatable, Drawable.Callback {
    private boolean CMM;
    private Rect Cp;
    Os DbA;
    private com.bytedance.adsdk.DbA.DbA.eli Dfc;
    private DbA FC;
    private boolean FS;
    private Rect GB;
    private Bitmap KM;
    private boolean MGA;
    private String NU;
    Xb Os;
    private boolean QX;
    private Matrix SSo;
    private final Matrix Ue;
    private View Uv;
    private Canvas VM;
    private boolean Vy;
    private com.bytedance.adsdk.DbA.Os.Os.DbA Xb;
    private final ArrayList<eli> aAs;
    private kb aGH;
    private Map<String, Typeface> aqO;
    private int bf;
    private RectF cyF;
    private boolean dV;
    private Matrix dZ;
    private final ValueAnimator.AnimatorUpdateListener du;
    private RectF eU;
    String eli;
    private boolean ev;
    private QX gG;
    private boolean kb;
    private boolean nGm;
    private com.bytedance.adsdk.DbA.DbA.DbA nlS;
    private aGH nn;
    private Rect nro;
    private RectF oWW;
    private Paint qj;
    private final com.bytedance.adsdk.DbA.MGA.Os ui;
    private boolean ujq;
    private boolean wC;

    private enum DbA {
        NONE,
        PLAY,
        RESUME
    }

    private interface eli {
        void eli(kb kbVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public FC() {
        com.bytedance.adsdk.DbA.MGA.Os os = new com.bytedance.adsdk.DbA.MGA.Os();
        this.ui = os;
        this.MGA = true;
        this.kb = false;
        this.wC = false;
        this.FC = DbA.NONE;
        this.aAs = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.DbA.FC.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (FC.this.Xb != null) {
                    FC.this.Xb.eli(FC.this.ui.MGA());
                }
            }
        };
        this.du = animatorUpdateListener;
        this.nGm = false;
        this.QX = true;
        this.bf = 255;
        this.gG = QX.AUTOMATIC;
        this.ujq = false;
        this.Ue = new Matrix();
        this.FS = false;
        os.addUpdateListener(animatorUpdateListener);
    }

    public void eli(View view) {
        this.Uv = view;
    }

    public View eli() {
        return this.Uv;
    }

    public void eli(boolean z, Context context) {
        if (this.dV == z) {
            return;
        }
        this.dV = z;
        if (this.aGH != null) {
            eli(context);
        }
    }

    public void eli(boolean z) {
        if (z != this.QX) {
            this.QX = z;
            com.bytedance.adsdk.DbA.Os.Os.DbA dbA = this.Xb;
            if (dbA != null) {
                dbA.DbA(z);
            }
            invalidateSelf();
        }
    }

    public com.bytedance.adsdk.DbA.Os.Os.DbA DbA() {
        return this.Xb;
    }

    public boolean Os() {
        return this.QX;
    }

    public void eli(String str) {
        this.NU = str;
    }

    public String aGH() {
        return this.NU;
    }

    public void DbA(boolean z) {
        this.nGm = z;
    }

    public boolean ui() {
        return this.nGm;
    }

    public boolean eli(kb kbVar, Context context) {
        if (this.aGH == kbVar) {
            return false;
        }
        this.FS = true;
        aAs();
        this.aGH = kbVar;
        eli(context);
        this.ui.eli(kbVar);
        aGH(this.ui.getAnimatedFraction());
        Iterator it = new ArrayList(this.aAs).iterator();
        while (it.hasNext()) {
            eli eliVar = (eli) it.next();
            if (eliVar != null) {
                eliVar.eli(kbVar);
            }
            it.remove();
        }
        this.aAs.clear();
        kbVar.DbA(this.CMM);
        oWW();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void eli(QX qx) {
        this.gG = qx;
        oWW();
    }

    public QX MGA() {
        return this.ujq ? QX.SOFTWARE : QX.HARDWARE;
    }

    private void oWW() {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            return;
        }
        this.ujq = this.gG.eli(Build.VERSION.SDK_INT, kbVar.eli(), kbVar.DbA());
    }

    public boolean kb() {
        return this.ujq;
    }

    public void Os(boolean z) {
        this.CMM = z;
        kb kbVar = this.aGH;
        if (kbVar != null) {
            kbVar.DbA(z);
        }
    }

    public void aGH(boolean z) {
        if (this.ev == z) {
            return;
        }
        this.ev = z;
        com.bytedance.adsdk.DbA.Os.Os.DbA dbA = this.Xb;
        if (dbA != null) {
            dbA.eli(z);
        }
    }

    public nGm wC() {
        kb kbVar = this.aGH;
        if (kbVar != null) {
            return kbVar.Os();
        }
        return null;
    }

    public void ui(boolean z) {
        this.Vy = z;
    }

    public boolean FC() {
        return this.Vy;
    }

    private void eli(Context context) {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            return;
        }
        com.bytedance.adsdk.DbA.Os.Os.DbA dbA = new com.bytedance.adsdk.DbA.Os.Os.DbA(this, CMM.eli(kbVar), kbVar.NU(), kbVar, context);
        this.Xb = dbA;
        if (this.ev) {
            dbA.eli(true);
        }
        this.Xb.DbA(this.QX);
    }

    public void aAs() {
        if (this.ui.isRunning()) {
            this.ui.cancel();
            if (!isVisible()) {
                this.FC = DbA.NONE;
            }
        }
        this.aGH = null;
        this.Xb = null;
        this.nlS = null;
        this.ui.wC();
        invalidateSelf();
    }

    public void MGA(boolean z) {
        this.wC = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.FS) {
            return;
        }
        this.FS = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.bf = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.bf;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ui.eli("Drawable#draw");
        try {
            if (this.ujq) {
                eli(canvas, this.Xb);
            } else {
                eli(canvas);
            }
        } catch (Throwable unused) {
        }
        this.FS = false;
        ui.DbA("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        du();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        nlS();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return CMM();
    }

    public void du() {
        if (this.Xb == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.6
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar) {
                    FC.this.du();
                }
            });
            return;
        }
        oWW();
        if (qj() || bf() == 0) {
            if (isVisible()) {
                this.ui.du();
                this.FC = DbA.NONE;
            } else {
                this.FC = DbA.PLAY;
            }
        }
        if (qj()) {
            return;
        }
        Os((int) (aqO() < 0.0f ? nn() : Dfc()));
        this.ui.nlS();
        if (isVisible()) {
            return;
        }
        this.FC = DbA.NONE;
    }

    public void nlS() {
        this.aAs.clear();
        this.ui.nlS();
        if (isVisible()) {
            return;
        }
        this.FC = DbA.NONE;
    }

    public void NU() {
        if (this.Xb == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.7
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar) {
                    FC.this.NU();
                }
            });
            return;
        }
        oWW();
        if (qj() || bf() == 0) {
            if (isVisible()) {
                this.ui.nn();
                this.FC = DbA.NONE;
            } else {
                this.FC = DbA.RESUME;
            }
        }
        if (qj()) {
            return;
        }
        Os((int) (aqO() < 0.0f ? nn() : Dfc()));
        this.ui.nlS();
        if (isVisible()) {
            return;
        }
        this.FC = DbA.NONE;
    }

    public void eli(final int i) {
        if (this.aGH == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.8
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar) {
                    FC.this.eli(i);
                }
            });
        } else {
            this.ui.eli(i);
        }
    }

    public float nn() {
        return this.ui.Dfc();
    }

    public void eli(final float f) {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.9
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar2) {
                    FC.this.eli(f);
                }
            });
        } else {
            eli((int) com.bytedance.adsdk.DbA.MGA.ui.eli(kbVar.MGA(), this.aGH.kb(), f));
        }
    }

    public void DbA(final int i) {
        if (this.aGH == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.10
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar) {
                    FC.this.DbA(i);
                }
            });
        } else {
            this.ui.DbA(i + 0.99f);
        }
    }

    public float Dfc() {
        return this.ui.aqO();
    }

    public void DbA(final float f) {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.11
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar2) {
                    FC.this.DbA(f);
                }
            });
        } else {
            this.ui.DbA(com.bytedance.adsdk.DbA.MGA.ui.eli(kbVar.MGA(), this.aGH.kb(), f));
        }
    }

    public void DbA(final String str) {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.12
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar2) {
                    FC.this.DbA(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.DbA.Os.MGA Os = kbVar.Os(str);
        if (Os == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        eli((int) Os.eli);
    }

    public void Os(final String str) {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.13
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar2) {
                    FC.this.Os(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.DbA.Os.MGA Os = kbVar.Os(str);
        if (Os == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        DbA((int) (Os.eli + Os.DbA));
    }

    public void aGH(final String str) {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.2
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar2) {
                    FC.this.aGH(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.DbA.Os.MGA Os = kbVar.Os(str);
        if (Os == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) Os.eli;
        eli(i, ((int) Os.DbA) + i);
    }

    public void eli(final int i, final int i2) {
        if (this.aGH == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.3
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar) {
                    FC.this.eli(i, i2);
                }
            });
        } else {
            this.ui.eli(i, i2 + 0.99f);
        }
    }

    public void Os(float f) {
        this.ui.Os(f);
    }

    public float aqO() {
        return this.ui.aAs();
    }

    public void eli(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ui.addUpdateListener(animatorUpdateListener);
    }

    public void DbA(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ui.removeUpdateListener(animatorUpdateListener);
    }

    public void dV() {
        this.ui.removeAllUpdateListeners();
        this.ui.addUpdateListener(this.du);
    }

    public void eli(Animator.AnimatorListener animatorListener) {
        this.ui.addListener(animatorListener);
    }

    public void DbA(Animator.AnimatorListener animatorListener) {
        this.ui.removeListener(animatorListener);
    }

    public void nGm() {
        this.ui.removeAllListeners();
    }

    public void Os(final int i) {
        if (this.aGH == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.4
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar) {
                    FC.this.Os(i);
                }
            });
        } else {
            this.ui.eli(i);
        }
    }

    public int QX() {
        return (int) this.ui.kb();
    }

    public void aGH(final float f) {
        if (this.aGH == null) {
            this.aAs.add(new eli() { // from class: com.bytedance.adsdk.DbA.FC.5
                @Override // com.bytedance.adsdk.DbA.FC.eli
                public void eli(kb kbVar) {
                    FC.this.aGH(f);
                }
            });
            return;
        }
        ui.eli("Drawable#setProgress");
        this.ui.eli(this.aGH.eli(f));
        ui.DbA("Drawable#setProgress");
    }

    public void aGH(int i) {
        this.ui.setRepeatMode(i);
    }

    public int Xb() {
        return this.ui.getRepeatMode();
    }

    public void ui(int i) {
        this.ui.setRepeatCount(i);
    }

    public int bf() {
        return this.ui.getRepeatCount();
    }

    public boolean CMM() {
        com.bytedance.adsdk.DbA.MGA.Os os = this.ui;
        if (os == null) {
            return false;
        }
        return os.isRunning();
    }

    boolean ev() {
        if (isVisible()) {
            return this.ui.isRunning();
        }
        return this.FC == DbA.PLAY || this.FC == DbA.RESUME;
    }

    private boolean qj() {
        return this.MGA || this.kb;
    }

    public void eli(Boolean bool) {
        this.MGA = bool.booleanValue();
    }

    public void kb(boolean z) {
        this.kb = z;
    }

    public void wC(boolean z) {
        this.ui.Os(z);
    }

    public void eli(aGH agh) {
        this.nn = agh;
        com.bytedance.adsdk.DbA.DbA.DbA dbA = this.nlS;
        if (dbA != null) {
            dbA.eli(agh);
        }
    }

    public void eli(Os os) {
        this.DbA = os;
        com.bytedance.adsdk.DbA.DbA.eli eliVar = this.Dfc;
        if (eliVar != null) {
            eliVar.eli(os);
        }
    }

    public void eli(Map<String, Typeface> map) {
        if (map == this.aqO) {
            return;
        }
        this.aqO = map;
        invalidateSelf();
    }

    public void eli(Xb xb) {
        this.Os = xb;
    }

    public Xb Vy() {
        return this.Os;
    }

    public boolean gG() {
        return this.aqO == null && this.Os == null && this.aGH.nn().size() > 0;
    }

    public kb ujq() {
        return this.aGH;
    }

    public void Ue() {
        this.aAs.clear();
        this.ui.cancel();
        if (isVisible()) {
            return;
        }
        this.FC = DbA.NONE;
    }

    public void KM() {
        this.aAs.clear();
        this.ui.NU();
        if (isVisible()) {
            return;
        }
        this.FC = DbA.NONE;
    }

    public float VM() {
        return this.ui.MGA();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            return -1;
        }
        return kbVar.aGH().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            return -1;
        }
        return kbVar.aGH().height();
    }

    public Bitmap eli(String str, Bitmap bitmap) {
        com.bytedance.adsdk.DbA.DbA.DbA nro = nro();
        if (nro == null) {
            return null;
        }
        Bitmap eli2 = nro.eli(str, bitmap);
        invalidateSelf();
        return eli2;
    }

    public Bitmap ui(String str) {
        com.bytedance.adsdk.DbA.DbA.DbA nro = nro();
        if (nro != null) {
            return nro.eli(str);
        }
        return null;
    }

    public aAs MGA(String str) {
        kb kbVar = this.aGH;
        if (kbVar == null) {
            return null;
        }
        return kbVar.aqO().get(str);
    }

    private com.bytedance.adsdk.DbA.DbA.DbA nro() {
        com.bytedance.adsdk.DbA.DbA.DbA dbA = this.nlS;
        if (dbA != null && !dbA.eli(cyF())) {
            this.nlS = null;
        }
        if (this.nlS == null) {
            this.nlS = new com.bytedance.adsdk.DbA.DbA.DbA(getCallback(), this.NU, this.nn, this.aGH.aqO());
        }
        return this.nlS;
    }

    public Typeface eli(com.bytedance.adsdk.DbA.Os.Os os) {
        Map<String, Typeface> map = this.aqO;
        if (map != null) {
            String eli2 = os.eli();
            if (map.containsKey(eli2)) {
                return map.get(eli2);
            }
            String DbA2 = os.DbA();
            if (map.containsKey(DbA2)) {
                return map.get(DbA2);
            }
            String str = os.eli() + "-" + os.Os();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.DbA.DbA.eli Cp = Cp();
        if (Cp != null) {
            return Cp.eli(os);
        }
        return null;
    }

    private com.bytedance.adsdk.DbA.DbA.eli Cp() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Dfc == null) {
            com.bytedance.adsdk.DbA.DbA.eli eliVar = new com.bytedance.adsdk.DbA.DbA.eli(getCallback(), this.DbA);
            this.Dfc = eliVar;
            String str = this.eli;
            if (str != null) {
                eliVar.eli(str);
            }
        }
        return this.Dfc;
    }

    public void kb(String str) {
        this.eli = str;
        com.bytedance.adsdk.DbA.DbA.eli Cp = Cp();
        if (Cp != null) {
            Cp.eli(str);
        }
    }

    private Context cyF() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.FC == DbA.PLAY) {
                du();
                return visible;
            }
            if (this.FC == DbA.RESUME) {
                NU();
                return visible;
            }
        } else {
            if (this.ui.isRunning()) {
                KM();
                this.FC = DbA.RESUME;
                return visible;
            }
            if (isVisible) {
                this.FC = DbA.NONE;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private void eli(Canvas canvas) {
        com.bytedance.adsdk.DbA.Os.Os.DbA dbA = this.Xb;
        kb kbVar = this.aGH;
        if (dbA == null || kbVar == null) {
            return;
        }
        this.Ue.reset();
        if (!getBounds().isEmpty()) {
            this.Ue.preScale(r2.width() / kbVar.aGH().width(), r2.height() / kbVar.aGH().height());
            this.Ue.preTranslate(r2.left, r2.top);
        }
        dbA.eli(canvas, this.Ue, this.bf);
    }

    public RectF GB() {
        return this.eU;
    }

    private void eli(Canvas canvas, com.bytedance.adsdk.DbA.Os.Os.DbA dbA) {
        if (this.aGH == null || dbA == null) {
            return;
        }
        eU();
        canvas.getMatrix(this.dZ);
        canvas.getClipBounds(this.GB);
        eli(this.GB, this.oWW);
        this.dZ.mapRect(this.oWW);
        eli(this.oWW, this.GB);
        if (this.QX) {
            this.eU.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            dbA.eli(this.eU, (Matrix) null, false);
        }
        this.dZ.mapRect(this.eU);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        eli(this.eU, width, height);
        if (!dZ()) {
            this.eU.intersect(this.GB.left, this.GB.top, this.GB.right, this.GB.bottom);
        }
        int ceil = (int) Math.ceil(this.eU.width());
        int ceil2 = (int) Math.ceil(this.eU.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        DbA(ceil, ceil2);
        if (this.FS) {
            this.Ue.set(this.dZ);
            this.Ue.preScale(width, height);
            this.Ue.postTranslate(-this.eU.left, -this.eU.top);
            this.KM.eraseColor(0);
            dbA.eli(this.VM, this.Ue, this.bf);
            this.dZ.invert(this.SSo);
            this.SSo.mapRect(this.cyF, this.eU);
            eli(this.cyF, this.Cp);
        }
        this.nro.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.KM, this.nro, this.Cp, this.qj);
    }

    private void eU() {
        if (this.VM != null) {
            return;
        }
        this.VM = new Canvas();
        this.eU = new RectF();
        this.dZ = new Matrix();
        this.SSo = new Matrix();
        this.GB = new Rect();
        this.oWW = new RectF();
        this.qj = new com.bytedance.adsdk.DbA.eli.eli();
        this.nro = new Rect();
        this.Cp = new Rect();
        this.cyF = new RectF();
    }

    private void DbA(int i, int i2) {
        Bitmap bitmap = this.KM;
        if (bitmap == null || bitmap.getWidth() < i || this.KM.getHeight() < i2) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.KM = createBitmap;
            this.VM.setBitmap(createBitmap);
            this.FS = true;
            return;
        }
        if (this.KM.getWidth() > i || this.KM.getHeight() > i2) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.KM, 0, 0, i, i2);
            this.KM = createBitmap2;
            this.VM.setBitmap(createBitmap2);
            this.FS = true;
        }
    }

    private void eli(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void eli(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void eli(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean dZ() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
