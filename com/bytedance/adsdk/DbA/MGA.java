package com.bytedance.adsdk.DbA;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.adsdk.DbA.kb;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class MGA extends ImageView {
    private static final du<Throwable> DbA = new du<Throwable>() { // from class: com.bytedance.adsdk.DbA.MGA.1
        @Override // com.bytedance.adsdk.DbA.du
        public void eli(Throwable th) {
            com.bytedance.adsdk.DbA.MGA.MGA.eli(th);
        }
    };
    private static final String eli = "MGA";
    private int CMM;
    private NU<kb> Dfc;
    private int FC;
    private eli GB;
    private final Runnable KM;
    private int MGA;
    private final Set<aGH> NU;
    private final du<kb> Os;
    private Handler QX;
    private JSONArray Ue;
    private DbA VM;
    private int Vy;
    private long Xb;
    private boolean aAs;
    private final du<Throwable> aGH;
    private kb aqO;
    private com.bytedance.adsdk.DbA.Os.Os.Os bf;
    private final Handler dV;
    private boolean du;
    private int ev;
    private int gG;
    private final FC kb;
    private int nGm;
    private boolean nlS;
    private final Set<Object> nn;
    private du<Throwable> ui;
    private String ujq;
    private String wC;

    public interface DbA {
    }

    private enum aGH {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public interface eli {
    }

    static /* synthetic */ int nGm(MGA mga) {
        int i = mga.CMM;
        mga.CMM = i - 1;
        return i;
    }

    static /* synthetic */ int ui(MGA mga) {
        int i = mga.nGm;
        mga.nGm = i + 1;
        return i;
    }

    public MGA(Context context) {
        super(context);
        this.Os = new du<kb>() { // from class: com.bytedance.adsdk.DbA.MGA.6
            @Override // com.bytedance.adsdk.DbA.du
            public void eli(kb kbVar) {
                MGA.this.setComposition(kbVar);
            }
        };
        this.aGH = new du<Throwable>() { // from class: com.bytedance.adsdk.DbA.MGA.7
            @Override // com.bytedance.adsdk.DbA.du
            public void eli(Throwable th) {
                if (MGA.this.MGA != 0) {
                    MGA mga = MGA.this;
                    mga.setImageResource(mga.MGA);
                }
                (MGA.this.ui == null ? MGA.DbA : MGA.this.ui).eli(th);
            }
        };
        this.MGA = 0;
        this.kb = new FC();
        this.aAs = false;
        this.du = false;
        this.nlS = true;
        this.NU = new HashSet();
        this.nn = new HashSet();
        this.dV = new Handler(Looper.getMainLooper());
        this.nGm = 0;
        this.Xb = 0L;
        this.KM = new Runnable() { // from class: com.bytedance.adsdk.DbA.MGA.4
            @Override // java.lang.Runnable
            public void run() {
                Log.i("TMe", "--==--- timer callback, timer: " + MGA.this.CMM + ", " + MGA.this.ev);
                if (MGA.this.CMM <= MGA.this.ev) {
                    if (MGA.this.Vy >= 0 && MGA.this.gG >= 0) {
                        Log.i("TMe", "--==--- timer end, play anim, startframe: " + MGA.this.Vy);
                        MGA.this.eli();
                        MGA mga = MGA.this;
                        mga.setFrame(mga.Vy);
                        MGA.this.eli(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.DbA.MGA.4.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (MGA.this.getFrame() < MGA.this.gG - 1 || MGA.this.getFrame() >= MGA.this.gG + 2) {
                                    return;
                                }
                                Log.i("TMe", "--==--- timer end, play anim, endframe: " + MGA.this.gG);
                                MGA.this.DbA(this);
                                MGA.this.MGA();
                            }
                        });
                    } else {
                        Log.i("TMe", "--==--- timer end, frame invalid: " + MGA.this.Vy + "," + MGA.this.gG);
                    }
                    if ((!TextUtils.isEmpty(MGA.this.ujq) || (MGA.this.Ue != null && MGA.this.Ue.length() > 0)) && MGA.this.VM != null) {
                        DbA unused = MGA.this.VM;
                        String unused2 = MGA.this.ujq;
                        JSONArray unused3 = MGA.this.Ue;
                        return;
                    }
                    return;
                }
                MGA.nGm(MGA.this);
                MGA.this.bf.eli(new StringBuilder().append(MGA.this.CMM).toString());
                MGA.this.invalidate();
                MGA.this.Dfc();
            }
        };
        wC();
    }

    private void wC() {
        setSaveEnabled(false);
        this.nlS = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        eli(0.0f, false);
        eli(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.kb.eli(Boolean.valueOf(com.bytedance.adsdk.DbA.MGA.MGA.eli(getContext()) != 0.0f));
        FC();
        aAs();
        nlS();
    }

    private void FC() {
        eli(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.DbA.MGA.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MGA.this.DbA(this);
                MGA.this.nn();
                MGA.this.du();
            }
        });
    }

    private void aAs() {
        eli(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.DbA.MGA.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                MGA.ui(MGA.this);
                kb.eli globalConfig = MGA.this.getGlobalConfig();
                if (globalConfig != null && globalConfig.aGH > 0 && globalConfig.aGH > MGA.this.nGm) {
                    MGA.this.nn();
                    MGA.this.eli();
                    MGA.this.setProgress(0.0f);
                } else {
                    MGA.this.DbA(this);
                    if (MGA.this.GB != null) {
                        eli unused = MGA.this.GB;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du() {
        final kb.eli globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.ui <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.MGA) && globalConfig.kb == null) {
            return;
        }
        int i = globalConfig.ui;
        if (i > getMaxFrame()) {
            i = (int) getMaxFrame();
        }
        final float maxFrame = i / getMaxFrame();
        eli(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.DbA.MGA.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame) {
                    return;
                }
                MGA.this.DbA(this);
                if (MGA.this.VM != null) {
                    DbA unused = MGA.this.VM;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(long j) {
        kb.eli globalConfig = getGlobalConfig();
        if (this.GB != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(j));
            if (globalConfig == null || globalConfig.DbA == null || globalConfig.DbA.isEmpty()) {
                return;
            }
            hashMap.putAll(globalConfig.DbA);
        }
    }

    private void nlS() {
        eli(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.DbA.MGA.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Xb Vy;
                final long elapsedRealtime = SystemClock.elapsedRealtime() - MGA.this.Xb;
                MGA.this.DbA(this);
                String playDelayedELExpressTimeS = MGA.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (Vy = MGA.this.kb.Vy()) != null) {
                    try {
                        int parseInt = Integer.parseInt(Vy.eli(playDelayedELExpressTimeS)) * 1000;
                        if (MGA.this.Xb > 0) {
                            long elapsedRealtime2 = (MGA.this.Xb + parseInt) - SystemClock.elapsedRealtime();
                            Log.i("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(elapsedRealtime2)));
                            if (elapsedRealtime2 > 0) {
                                MGA.this.MGA();
                                MGA.this.setVisibility(8);
                                if (MGA.this.QX == null) {
                                    MGA.this.QX = new Handler(Looper.getMainLooper());
                                }
                                MGA.this.QX.removeCallbacksAndMessages(null);
                                MGA.this.QX.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.DbA.MGA.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Log.i("TMe", "--==-- lottie real start play");
                                        MGA.this.setVisibility(0);
                                        MGA.this.eli();
                                        MGA.this.eli(elapsedRealtime);
                                    }
                                }, elapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                MGA.this.eli(elapsedRealtime);
            }
        });
    }

    public void setView(View view) {
        this.kb.eli(view);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        NU();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        NU();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        NU();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        FC fc;
        if (!this.aAs && drawable == (fc = this.kb) && fc.CMM()) {
            MGA();
        } else if (!this.aAs && (drawable instanceof FC)) {
            FC fc2 = (FC) drawable;
            if (fc2.CMM()) {
                fc2.KM();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof FC) && ((FC) drawable).MGA() == QX.SOFTWARE) {
            this.kb.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        FC fc = this.kb;
        if (drawable2 == fc) {
            super.invalidateDrawable(fc);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        kb ujq;
        FC fc = this.kb;
        if (fc == null || (ujq = fc.ujq()) == null) {
            return null;
        }
        return ujq.FC();
    }

    private aAs eli(String str) {
        FC fc;
        kb ujq;
        Map<String, aAs> aqO;
        if (TextUtils.isEmpty(str) || (fc = this.kb) == null || (ujq = fc.ujq()) == null || (aqO = ujq.aqO()) == null) {
            return null;
        }
        return aqO.get(str);
    }

    private kb.DbA getGlobalEvent() {
        kb ujq;
        FC fc = this.kb;
        if (fc == null || (ujq = fc.ujq()) == null) {
            return null;
        }
        return ujq.aAs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public kb.eli getGlobalConfig() {
        kb ujq;
        FC fc = this.kb;
        if (fc == null || (ujq = fc.ujq()) == null) {
            return null;
        }
        return ujq.du();
    }

    private void eli(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            Log.i("TMe", "--==--- inel enter, play anim, startframe: ".concat(String.valueOf(i)));
            aqO();
            eli();
            setFrame(i);
            eli(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.DbA.MGA.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (MGA.this.getFrame() < i2 - 1 || MGA.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    Log.i("TMe", "--==--- inel enter, play anim end, endframe: " + i2 + ", realFrame: " + MGA.this.getFrame());
                    MGA.this.DbA(this);
                    MGA.this.MGA();
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void eli(String str, String str2, JSONArray jSONArray) {
        kb.DbA globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.eli;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.Os;
            }
        }
        if (!TextUtils.isEmpty(str2) || jSONArray == null) {
            return;
        }
        jSONArray.length();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        com.bytedance.adsdk.DbA.Os.Os.eli eli2 = eli(motionEvent);
        if (eli2 != null) {
            String FC = eli2.FC();
            if (eli2 instanceof com.bytedance.adsdk.DbA.Os.Os.DbA) {
                if (getGlobalConfig() == null || getGlobalConfig().eli != 1) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            }
            if (FC != null && FC.startsWith("CSJCLOSE")) {
                aqO();
            }
            aAs eli3 = eli(eli2.ui());
            if (eli3 != null && motionEvent.getAction() == 1) {
                eli(FC, eli3.ui(), eli3.kb());
                int[][] MGA = eli3.MGA();
                if (MGA != null) {
                    eli(MGA);
                } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().DbA) != null) {
                    eli(iArr);
                }
            }
            if (FC == null || !FC.startsWith("CSJNTP")) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        if (getGlobalConfig() == null || getGlobalConfig().eli != 1) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private com.bytedance.adsdk.DbA.Os.Os.eli eli(MotionEvent motionEvent) {
        com.bytedance.adsdk.DbA.Os.Os.DbA DbA2;
        FC fc = this.kb;
        if (fc == null || (DbA2 = fc.DbA()) == null) {
            return null;
        }
        return eli(DbA2, motionEvent);
    }

    private com.bytedance.adsdk.DbA.Os.Os.eli eli(com.bytedance.adsdk.DbA.Os.Os.DbA dbA, MotionEvent motionEvent) {
        com.bytedance.adsdk.DbA.Os.Os.eli eli2;
        for (com.bytedance.adsdk.DbA.Os.Os.eli eliVar : dbA.nlS()) {
            if (eliVar instanceof com.bytedance.adsdk.DbA.Os.Os.DbA) {
                if (eliVar.wC() && eliVar.MGA() > 0.0f) {
                    RectF rectF = new RectF();
                    eliVar.eli(rectF, eliVar.aGH(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (eli2 = eli((com.bytedance.adsdk.DbA.Os.Os.DbA) eliVar, motionEvent)) != null) {
                        return eli2;
                    }
                }
            } else if (eliVar.wC() && eliVar.MGA() > 0.0f) {
                RectF rectF2 = new RectF();
                FC fc = this.kb;
                if (fc != null && fc.kb()) {
                    eliVar.eli(rectF2, eliVar.aGH(), true);
                    RectF GB = this.kb.GB();
                    if (GB != null) {
                        eli(rectF2, GB);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    eliVar.eli(rectF3, eliVar.aGH(), true);
                    DbA(rectF2, rectF3);
                }
                if (eli(motionEvent, rectF2)) {
                    return eliVar;
                }
            }
        }
        return null;
    }

    private boolean eli(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void eli(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        if (width == 0.0f || height == 0.0f || width2 == 0.0f || height2 == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.eli[getScaleType().ordinal()];
        if (i == 1) {
            eli(matrix, width, height, width2, height2);
        } else if (i == 2) {
            DbA(matrix, width, height, width2, height2);
        } else if (i == 3) {
            Os(matrix, width, height, width2, height2);
        } else if (i == 4) {
            aGH(matrix, width, height, width2, height2);
        }
        matrix.mapRect(rectF);
    }

    /* renamed from: com.bytedance.adsdk.DbA.MGA$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            eli = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eli[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void DbA(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float width2 = this.kb.getBounds().width();
        float height2 = this.kb.getBounds().height();
        if (width == 0.0f || height == 0.0f || width2 == 0.0f || height2 == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.eli[getScaleType().ordinal()];
        if (i == 1) {
            eli(matrix, width, height, width2, height2);
        } else if (i == 2) {
            DbA(matrix, width, height, width2, height2);
        } else if (i == 3) {
            Os(matrix, width, height, width2, height2);
        } else if (i == 4) {
            aGH(matrix, width, height, width2, height2);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void eli(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    private void DbA(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    private void Os(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void aGH(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Os os = new Os(super.onSaveInstanceState());
        os.eli = this.wC;
        os.DbA = this.FC;
        os.Os = this.kb.VM();
        os.aGH = this.kb.ev();
        os.ui = this.kb.aGH();
        os.MGA = this.kb.Xb();
        os.kb = this.kb.bf();
        return os;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof Os)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Os os = (Os) parcelable;
        super.onRestoreInstanceState(os.getSuperState());
        this.wC = os.eli;
        if (!this.NU.contains(aGH.SET_ANIMATION) && !TextUtils.isEmpty(this.wC)) {
            setAnimation(this.wC);
        }
        this.FC = os.DbA;
        if (!this.NU.contains(aGH.SET_ANIMATION) && (i = this.FC) != 0) {
            setAnimation(i);
        }
        if (!this.NU.contains(aGH.SET_PROGRESS)) {
            eli(os.Os, false);
        }
        if (!this.NU.contains(aGH.PLAY_OPTION) && os.aGH) {
            eli();
        }
        if (!this.NU.contains(aGH.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(os.ui);
        }
        if (!this.NU.contains(aGH.SET_REPEAT_MODE)) {
            setRepeatMode(os.MGA);
        }
        if (this.NU.contains(aGH.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(os.kb);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.du) {
            return;
        }
        this.kb.du();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aqO();
        Handler handler = this.QX;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Os();
        DbA();
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.kb.kb(z);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.kb.wC(z);
    }

    public void eli(boolean z, Context context) {
        this.kb.eli(z, context);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.kb.eli(z);
    }

    public boolean getClipToCompositionBounds() {
        return this.kb.Os();
    }

    public void setCacheComposition(boolean z) {
        this.nlS = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.kb.aGH(z);
    }

    public void setAnimation(int i) {
        this.FC = i;
        this.wC = null;
        setCompositionTask(eli(i));
    }

    private NU<kb> eli(final int i) {
        if (isInEditMode()) {
            return new NU<>(new Callable<nlS<kb>>() { // from class: com.bytedance.adsdk.DbA.MGA.13
                @Override // java.util.concurrent.Callable
                /* renamed from: eli, reason: merged with bridge method [inline-methods] */
                public nlS<kb> call() throws Exception {
                    return MGA.this.nlS ? wC.DbA(MGA.this.getContext(), i) : wC.DbA(MGA.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.nlS ? wC.eli(getContext(), i) : wC.eli(getContext(), i, (String) null);
    }

    public void setAnimation(String str) {
        this.wC = str;
        this.FC = 0;
        setCompositionTask(DbA(str));
    }

    private NU<kb> DbA(final String str) {
        if (isInEditMode()) {
            return new NU<>(new Callable<nlS<kb>>() { // from class: com.bytedance.adsdk.DbA.MGA.2
                @Override // java.util.concurrent.Callable
                /* renamed from: eli, reason: merged with bridge method [inline-methods] */
                public nlS<kb> call() throws Exception {
                    return MGA.this.nlS ? wC.Os(MGA.this.getContext(), str) : wC.Os(MGA.this.getContext(), str, null);
                }
            }, true);
        }
        return this.nlS ? wC.DbA(getContext(), str) : wC.DbA(getContext(), str, (String) null);
    }

    public void setAnimationFromJson(String str) {
        eli(str, (String) null);
    }

    public void eli(String str, String str2) {
        eli(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void eli(InputStream inputStream, String str) {
        setCompositionTask(wC.eli(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.nlS ? wC.eli(getContext(), str) : wC.eli(getContext(), str, (String) null));
    }

    public void setFailureListener(du<Throwable> duVar) {
        this.ui = duVar;
    }

    public void setFallbackResource(int i) {
        this.MGA = i;
    }

    private void setCompositionTask(NU<kb> nu) {
        this.NU.add(aGH.SET_ANIMATION);
        dV();
        NU();
        this.Dfc = nu.eli(this.Os).Os(this.aGH);
    }

    private void NU() {
        NU<kb> nu = this.Dfc;
        if (nu != null) {
            nu.DbA(this.Os);
            this.Dfc.aGH(this.aGH);
        }
    }

    private com.bytedance.adsdk.DbA.Os.Os.Os eli(com.bytedance.adsdk.DbA.Os.Os.DbA dbA, String str) {
        for (com.bytedance.adsdk.DbA.Os.Os.eli eliVar : dbA.nlS()) {
            if (eliVar instanceof com.bytedance.adsdk.DbA.Os.Os.DbA) {
                com.bytedance.adsdk.DbA.Os.Os.Os eli2 = eli((com.bytedance.adsdk.DbA.Os.Os.DbA) eliVar, str);
                if (eli2 != null) {
                    return eli2;
                }
            } else if (TextUtils.equals(str, eliVar.FC()) && (eliVar instanceof com.bytedance.adsdk.DbA.Os.Os.Os)) {
                return (com.bytedance.adsdk.DbA.Os.Os.Os) eliVar;
            }
        }
        return null;
    }

    private com.bytedance.adsdk.DbA.Os.Os.Os Os(String str) {
        com.bytedance.adsdk.DbA.Os.Os.DbA DbA2;
        FC fc = this.kb;
        if (fc == null || (DbA2 = fc.DbA()) == null) {
            return null;
        }
        return eli(DbA2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn() {
        FC fc;
        int i;
        int i2;
        final int i3;
        if (this.aqO == null || (fc = this.kb) == null) {
            return;
        }
        Xb Vy = fc.Vy();
        kb.Os wC = this.aqO.wC();
        if (wC == null || Vy == null) {
            return;
        }
        final int i4 = wC.eli;
        if (i4 < 0) {
            Log.i("TMe", "--==--- timer fail, ke is invalid: ".concat(String.valueOf(i4)));
            return;
        }
        final int i5 = -1;
        if (wC.ui == null || wC.ui.length < 2) {
            i = -1;
            i2 = -1;
        } else {
            i = wC.ui[0];
            i2 = wC.ui[1];
        }
        String eli2 = Vy.eli(wC.Os);
        String eli3 = Vy.eli(wC.aGH);
        try {
            i3 = Integer.parseInt(eli2);
            try {
                i5 = Integer.parseInt(eli3);
            } catch (NumberFormatException unused) {
            }
        } catch (NumberFormatException unused2) {
            i3 = -1;
        }
        Log.i("TMe", "--==--- prepare timer, startS: " + i3 + ", lenS: " + i5);
        if (!TextUtils.isEmpty(wC.DbA)) {
            Log.i("TMe", "--==--- timer, id:" + wC.DbA);
            com.bytedance.adsdk.DbA.Os.Os.Os Os2 = Os(wC.DbA);
            if (Os2 != null) {
                Log.i("TMe", "--==--- timer success");
                this.ujq = wC.MGA;
                this.Ue = wC.kb;
                this.bf = Os2;
                this.CMM = i3;
                this.ev = i3 - i5;
                this.Vy = i;
                this.gG = i2;
                Os2.eli(new StringBuilder().append(this.CMM).toString());
                eli(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.DbA.MGA.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (MGA.this.getFrame() < i4 - 1 || MGA.this.getFrame() >= i4 + 2) {
                            return;
                        }
                        Log.i("TMe", "--==--- enter timer point, frame: " + MGA.this.getFrame());
                        MGA.this.DbA(this);
                        if (i3 >= 0 && i5 >= 0) {
                            Log.i("TMe", "--==--- enter timer callback, start timer");
                            MGA.this.Dfc();
                        } else {
                            Log.i("TMe", "--==--- enter timer callback, NOT start timer");
                        }
                        MGA.this.MGA();
                    }
                });
                return;
            }
            return;
        }
        Log.i("TMe", "--==--- timer fail, id is invalid: " + wC.DbA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dfc() {
        this.dV.postDelayed(this.KM, 1000L);
    }

    private void aqO() {
        this.dV.removeCallbacksAndMessages(null);
    }

    public void setComposition(kb kbVar) {
        if (ui.eli) {
            Log.v(eli, "Set Composition \n".concat(String.valueOf(kbVar)));
        }
        this.kb.setCallback(this);
        this.aqO = kbVar;
        this.aAs = true;
        boolean eli2 = this.kb.eli(kbVar, getContext().getApplicationContext());
        this.aAs = false;
        if (getDrawable() != this.kb || eli2) {
            if (!eli2) {
                nGm();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.nn.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public kb getComposition() {
        return this.aqO;
    }

    public void eli() {
        if (this.Xb == 0) {
            this.Xb = SystemClock.elapsedRealtime();
        }
        this.NU.add(aGH.PLAY_OPTION);
        this.kb.du();
    }

    public void setMinFrame(int i) {
        this.kb.eli(i);
    }

    public float getMinFrame() {
        return this.kb.nn();
    }

    public void setMinProgress(float f) {
        this.kb.eli(f);
    }

    public void setMaxFrame(int i) {
        this.kb.DbA(i);
    }

    public float getMaxFrame() {
        return this.kb.Dfc();
    }

    public void setMaxProgress(float f) {
        this.kb.DbA(f);
    }

    public void setMinFrame(String str) {
        this.kb.DbA(str);
    }

    public void setMaxFrame(String str) {
        this.kb.Os(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.kb.aGH(str);
    }

    public void setSpeed(float f) {
        this.kb.Os(f);
    }

    public float getSpeed() {
        return this.kb.aqO();
    }

    public void eli(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kb.eli(animatorUpdateListener);
    }

    public void DbA(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kb.DbA(animatorUpdateListener);
    }

    public void DbA() {
        this.kb.dV();
    }

    public void eli(Animator.AnimatorListener animatorListener) {
        this.kb.eli(animatorListener);
    }

    public void DbA(Animator.AnimatorListener animatorListener) {
        this.kb.DbA(animatorListener);
    }

    public void Os() {
        this.kb.nGm();
    }

    public void eli(boolean z) {
        this.kb.ui(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.NU.add(aGH.SET_REPEAT_MODE);
        this.kb.aGH(i);
    }

    public int getRepeatMode() {
        return this.kb.Xb();
    }

    public void setRepeatCount(int i) {
        this.NU.add(aGH.SET_REPEAT_COUNT);
        this.kb.ui(i);
    }

    public int getRepeatCount() {
        return this.kb.bf();
    }

    public boolean aGH() {
        return this.kb.CMM();
    }

    public void setImageAssetsFolder(String str) {
        this.kb.eli(str);
    }

    public String getImageAssetsFolder() {
        return this.kb.aGH();
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.kb.DbA(z);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.kb.ui();
    }

    public Bitmap eli(String str, Bitmap bitmap) {
        return this.kb.eli(str, bitmap);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.DbA.aGH agh) {
        this.kb.eli(agh);
    }

    public void setDefaultFontFileExtension(String str) {
        this.kb.kb(str);
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.DbA.Os os) {
        this.kb.eli(os);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.kb.eli(map);
    }

    public void setTextDelegate(Xb xb) {
        this.kb.eli(xb);
    }

    public void ui() {
        this.NU.add(aGH.PLAY_OPTION);
        this.kb.Ue();
    }

    public void MGA() {
        this.du = false;
        this.kb.KM();
    }

    public void setFrame(int i) {
        this.kb.Os(i);
    }

    public int getFrame() {
        return this.kb.QX();
    }

    public void setProgress(float f) {
        eli(f, true);
    }

    private void eli(float f, boolean z) {
        if (z) {
            this.NU.add(aGH.SET_PROGRESS);
        }
        this.kb.aGH(f);
    }

    public float getProgress() {
        return this.kb.VM();
    }

    public long getDuration() {
        kb kbVar = this.aqO;
        if (kbVar != null) {
            return (long) kbVar.ui();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kb.Os(z);
    }

    public nGm getPerformanceTracker() {
        return this.kb.wC();
    }

    private void dV() {
        this.aqO = null;
        this.kb.aAs();
    }

    public void setSafeMode(boolean z) {
        this.kb.MGA(z);
    }

    public void setRenderMode(QX qx) {
        this.kb.eli(qx);
    }

    public QX getRenderMode() {
        return this.kb.MGA();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.kb.ui(z);
    }

    private void nGm() {
        boolean aGH2 = aGH();
        setImageDrawable(null);
        setImageDrawable(this.kb);
        if (aGH2) {
            this.kb.NU();
        }
    }

    private static class Os extends View.BaseSavedState {
        public static final Parcelable.Creator<Os> CREATOR = new Parcelable.Creator<Os>() { // from class: com.bytedance.adsdk.DbA.MGA.Os.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public Os createFromParcel(Parcel parcel) {
                return new Os(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public Os[] newArray(int i) {
                return new Os[i];
            }
        };
        int DbA;
        int MGA;
        float Os;
        boolean aGH;
        String eli;
        int kb;
        String ui;

        Os(Parcelable parcelable) {
            super(parcelable);
        }

        private Os(Parcel parcel) {
            super(parcel);
            this.eli = parcel.readString();
            this.Os = parcel.readFloat();
            this.aGH = parcel.readInt() == 1;
            this.ui = parcel.readString();
            this.MGA = parcel.readInt();
            this.kb = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.eli);
            parcel.writeFloat(this.Os);
            parcel.writeInt(this.aGH ? 1 : 0);
            parcel.writeString(this.ui);
            parcel.writeInt(this.MGA);
            parcel.writeInt(this.kb);
        }
    }

    public void setLottieClicklistener(DbA dbA) {
        this.VM = dbA;
    }

    public void setLottieAnimListener(eli eliVar) {
        this.GB = eliVar;
    }
}
