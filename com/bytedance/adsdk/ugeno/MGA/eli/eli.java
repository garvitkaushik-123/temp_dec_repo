package com.bytedance.adsdk.ugeno.MGA.eli;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.adsdk.ugeno.MGA.aGH;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class eli extends LinearLayout {
    protected int DbA;
    private int FC;
    private int MGA;
    protected int Os;
    private float aAs;
    private List<View> aGH;
    private float du;
    protected Context eli;
    private int kb;
    private String nlS;
    private int ui;
    private boolean wC;

    public abstract Drawable DbA(int i);

    public eli(Context context) {
        super(context);
        this.ui = -65536;
        this.MGA = -16776961;
        this.kb = 5;
        this.DbA = 40;
        this.Os = 20;
        this.nlS = "row";
        this.eli = context;
        this.aGH = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorX(float f) {
        this.aAs = f;
    }

    public void setIndicatorY(float f) {
        this.du = f;
    }

    public void setIndicatorDirection(String str) {
        this.nlS = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorWidth(int i) {
        this.DbA = i;
    }

    public void setIndicatorHeight(int i) {
        this.Os = i;
    }

    public void eli(int i, int i2) {
        Iterator<View> it = this.aGH.iterator();
        while (it.hasNext()) {
            it.next().setBackground(DbA(this.MGA));
        }
        if (i < 0 || i >= this.aGH.size()) {
            i = 0;
        }
        if (this.aGH.size() > 0) {
            this.aGH.get(i).setBackground(DbA(this.ui));
            this.FC = i2;
        }
    }

    public int getSize() {
        return this.aGH.size();
    }

    public void eli() {
        post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.MGA.eli.eli.1
            @Override // java.lang.Runnable
            public void run() {
                eli.this.aGH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (frameLayout == null) {
            return;
        }
        float width = frameLayout.getWidth();
        float height = frameLayout.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        float width2 = getWidth();
        layoutParams.topMargin = (int) (((int) ((height * r5) / 100.0f)) - ((getHeight() * this.du) / 100.0f));
        layoutParams.leftMargin = (int) (((int) ((width * r0) / 100.0f)) - ((width2 * this.aAs) / 100.0f));
        setLayoutParams(layoutParams);
    }

    public void setSelectedColor(int i) {
        this.ui = i;
    }

    public void setLoop(boolean z) {
        this.wC = z;
    }

    public void setUnSelectedColor(int i) {
        this.MGA = i;
    }

    public void eli(int i) {
        if (this instanceof DbA) {
            this.Os = this.DbA;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.DbA, this.Os);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.kb;
            layoutParams.bottomMargin = this.kb;
        } else {
            layoutParams.leftMargin = this.kb;
            layoutParams.rightMargin = this.kb;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.DbA, this.Os);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.kb;
            layoutParams2.bottomMargin = this.kb;
        } else {
            layoutParams2.leftMargin = this.kb;
            layoutParams2.rightMargin = this.kb;
        }
        int eli = aGH.eli(this.wC, this.FC, this.aGH.size());
        int eli2 = aGH.eli(this.wC, i, this.aGH.size());
        if (this.aGH.size() == 0) {
            eli2 = 0;
        }
        if (!this.aGH.isEmpty() && aGH.eli(eli, this.aGH) && aGH.eli(eli2, this.aGH)) {
            this.aGH.get(eli).setBackground(DbA(this.MGA));
            this.aGH.get(eli).setLayoutParams(layoutParams2);
            this.aGH.get(eli2).setBackground(DbA(this.ui));
            this.aGH.get(eli2).setLayoutParams(layoutParams);
            this.FC = i;
        }
    }

    public void DbA() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DbA) {
            this.Os = this.DbA;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.DbA, this.Os);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.kb;
            layoutParams.bottomMargin = this.kb;
        } else {
            layoutParams.leftMargin = this.kb;
            layoutParams.rightMargin = this.kb;
        }
        addView(view, layoutParams);
        view.setBackground(DbA(this.MGA));
        this.aGH.add(view);
    }

    public void Os() {
        this.aGH.clear();
        removeAllViews();
    }
}
