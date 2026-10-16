package com.bytedance.adsdk.ugeno.eli;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.eli.Os;
import com.bytedance.adsdk.ugeno.eli.eli.eli;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends AnimatorListenerAdapter {
    private Os DbA;
    private DbA FC;
    private int MGA = 1;
    private ValueAnimator Os;
    private Context aGH;
    private com.bytedance.adsdk.ugeno.DbA.Os eli;
    private com.bytedance.adsdk.ugeno.eli.eli.eli kb;
    private int ui;
    private String wC;

    public eli(Context context, com.bytedance.adsdk.ugeno.DbA.Os os, Os os2) {
        this.eli = os;
        this.DbA = os2;
        this.aGH = context;
    }

    public void eli() {
        ValueAnimator valueAnimator = this.Os;
        if (valueAnimator == null || this.MGA == 0 || this.ui == Integer.MIN_VALUE) {
            return;
        }
        valueAnimator.start();
    }

    public void eli(DbA dbA) {
        this.FC = dbA;
    }

    public void DbA() {
        ValueAnimator valueAnimator = this.Os;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void Os() {
        ValueAnimator valueAnimator = this.Os;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator aGH() {
        String key;
        com.bytedance.adsdk.ugeno.eli.DbA.eli os;
        Os os2 = this.DbA;
        if (os2 == null || this.eli == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> DbA = os2.DbA();
        ArrayList arrayList = new ArrayList();
        if (DbA != null && !DbA.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : DbA.entrySet()) {
                if (entry != null) {
                    key = entry.getKey();
                    String Os = ui.eli(key).Os();
                    Os.hashCode();
                    switch (Os) {
                        case "int":
                            os = new com.bytedance.adsdk.ugeno.eli.DbA.Os(this.aGH, this.eli, key, entry.getValue());
                            break;
                        case "float":
                            os = new com.bytedance.adsdk.ugeno.eli.DbA.DbA(this.aGH, this.eli, key, entry.getValue());
                            break;
                        case "point":
                            os = new com.bytedance.adsdk.ugeno.eli.DbA.aGH(this.aGH, this.eli, key, entry.getValue());
                            break;
                        default:
                            os = null;
                            break;
                    }
                    if (os != null) {
                        arrayList.addAll(os.ui());
                    }
                }
            }
        }
        JSONObject eli = this.DbA.eli();
        if (eli != null) {
            com.bytedance.adsdk.ugeno.eli.eli.eli eli2 = eli.C0125eli.eli(this.eli, eli);
            this.kb = eli2;
            if (eli2 != null) {
                arrayList.addAll(eli2.Os());
            }
        }
        final View du = this.eli.du();
        if (du == null) {
            return null;
        }
        final Os.eli kb = this.DbA.kb();
        if (kb != null) {
            du.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.eli.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = du.getWidth();
                    int height = du.getHeight();
                    du.setPivotX(aGH.eli(kb.eli, width));
                    du.setPivotY(aGH.eli(kb.DbA, height));
                }
            });
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(du, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.ui = aGH.eli(this.DbA.aGH());
        ofPropertyValuesHolder.setDuration(this.DbA.Os());
        int i = this.ui;
        if (i != Integer.MIN_VALUE) {
            ofPropertyValuesHolder.setRepeatCount(i);
        }
        this.MGA = this.DbA.aAs();
        this.wC = this.DbA.FC();
        ofPropertyValuesHolder.setStartDelay(this.DbA.MGA());
        ofPropertyValuesHolder.setRepeatMode(aGH.eli(this.DbA.ui()));
        ofPropertyValuesHolder.setInterpolator(aGH.DbA(this.DbA.wC()));
        ofPropertyValuesHolder.addListener(this);
        this.Os = ofPropertyValuesHolder;
        return ofPropertyValuesHolder;
    }

    public void eli(Canvas canvas) {
        com.bytedance.adsdk.ugeno.eli.eli.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.eli(canvas);
        }
    }

    public void DbA(Canvas canvas) {
        com.bytedance.adsdk.ugeno.eli.eli.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.DbA(canvas);
        }
    }

    public void eli(int i, int i2) {
        com.bytedance.adsdk.ugeno.eli.eli.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.eli(i, i2);
        }
    }

    public String ui() {
        return this.wC;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        DbA dbA = this.FC;
        if (dbA != null) {
            dbA.eli();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        DbA dbA = this.FC;
        if (dbA != null) {
            dbA.DbA();
        }
    }
}
