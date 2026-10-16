package com.bytedance.adsdk.ugeno.core;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.core.eli;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class aAs {
    private eli DbA;
    private int MGA;
    private AnimatorSet Os = new AnimatorSet();
    private View aGH;
    Paint eli;
    private String kb;
    private int ui;

    public aAs(View view, eli eliVar) {
        this.aGH = view;
        this.DbA = eliVar;
        Paint paint = new Paint();
        this.eli = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0187, code lost:
    
        if (r2.equals("accelerate") == false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli() {
        ArrayList arrayList = new ArrayList();
        List<eli.C0123eli> Os = this.DbA.Os();
        if (Os == null || Os.size() <= 0) {
            return;
        }
        for (eli.C0123eli c0123eli : Os) {
            if (c0123eli != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0123eli.eli());
                if (TextUtils.equals(c0123eli.ui(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0123eli.ui(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0123eli.ui());
                }
                objectAnimator.setStartDelay(c0123eli.aGH());
                objectAnimator.setTarget(this.aGH);
                char c = 0;
                if (TextUtils.equals(c0123eli.ui(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0123eli.MGA(), (int) c0123eli.kb());
                    Log.d("UGenAnimation", "playAnimation: from = " + c0123eli.MGA() + "; to=" + c0123eli.kb());
                } else {
                    objectAnimator.setFloatValues(c0123eli.MGA(), c0123eli.kb());
                }
                int DbA = (int) this.DbA.DbA();
                if (DbA != 0) {
                    objectAnimator.setRepeatCount(DbA);
                } else {
                    objectAnimator.setRepeatCount((int) c0123eli.DbA());
                }
                if (TextUtils.equals(c0123eli.ui(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String MGA = this.DbA.MGA();
                if (TextUtils.isEmpty(MGA)) {
                    MGA = c0123eli.Os();
                }
                if (TextUtils.equals(MGA, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0123eli.wC() != null && c0123eli.wC().length > 0) {
                    objectAnimator.setFloatValues(c0123eli.wC());
                }
                if (TextUtils.equals(c0123eli.ui(), "rotationX")) {
                    this.aGH.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.aAs.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aAs.this.aGH.setPivotX(aAs.this.aGH.getWidth() / 2.0f);
                            aAs.this.aGH.setPivotY(aAs.this.aGH.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0123eli.ui(), "ripple")) {
                    this.kb = c0123eli.aAs();
                }
                String FC = c0123eli.FC();
                FC.hashCode();
                switch (FC.hashCode()) {
                    case -1354466595:
                        break;
                    case -1263948740:
                        if (FC.equals("decelerate")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1102672091:
                        if (FC.equals("linear")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 475910905:
                        if (FC.equals("accelerateDecelerate")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1312628413:
                        if (FC.equals("standard")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case 1:
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case 2:
                    case 4:
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case 3:
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.DbA.aGH() != 0) {
            this.Os.setDuration(this.DbA.aGH());
        }
        this.Os.setStartDelay(this.DbA.ui());
        if (TextUtils.equals(this.DbA.eli(), "sequentially")) {
            this.Os.playSequentially(arrayList);
        } else {
            this.Os.playTogether(arrayList);
        }
        this.Os.start();
    }

    public void DbA() {
        AnimatorSet animatorSet = this.Os;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void eli(Canvas canvas, IAnimation iAnimation) {
        try {
            if (iAnimation.getRipple() == 0.0f || TextUtils.isEmpty(this.kb)) {
                return;
            }
            this.eli.setColor(com.bytedance.adsdk.ugeno.kb.eli.eli(this.kb));
            this.eli.setAlpha(90);
            ((ViewGroup) this.aGH.getParent()).setClipChildren(true);
            canvas.drawCircle(this.ui, this.MGA, Math.min(r0, r2) * 2 * iAnimation.getRipple(), this.eli);
        } catch (Throwable th) {
            Log.d("UGenAnimation", "ripple animation error " + th.getMessage());
        }
    }

    public void eli(int i, int i2) {
        this.ui = i / 2;
        this.MGA = i2 / 2;
    }
}
