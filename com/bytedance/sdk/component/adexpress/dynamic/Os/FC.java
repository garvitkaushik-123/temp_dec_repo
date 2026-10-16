package com.bytedance.sdk.component.adexpress.dynamic.Os;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.MGA.ujq;

/* loaded from: classes3.dex */
public class FC extends FrameLayout implements wC {
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui DbA;
    private int FC;
    private String MGA;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.kb Os;
    private boolean aAs;
    private View aGH;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs du;
    private Context eli;
    private com.bytedance.sdk.component.adexpress.MGA.nGm kb;
    private com.bytedance.sdk.component.adexpress.DbA.NU nlS;
    private kb ui;
    private View.OnTouchListener wC;

    public FC(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar) {
        super(context);
        this.eli = context;
        this.DbA = uiVar;
        this.Os = kbVar;
        kb();
    }

    public FC(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui uiVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb kbVar, com.bytedance.sdk.component.adexpress.dynamic.aGH.aAs aas, com.bytedance.sdk.component.adexpress.DbA.NU nu) {
        super(context);
        this.eli = context;
        this.DbA = uiVar;
        this.Os = kbVar;
        this.du = aas;
        this.nlS = nu;
        kb();
    }

    private void kb() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.MGA = this.Os.FS();
        this.FC = this.Os.ikX();
        this.aAs = this.Os.rQ();
        kb eli = aAs.eli(this.eli, this.DbA, this.Os, this.du, this.nlS);
        this.ui = eli;
        if (eli != null) {
            this.aGH = eli.Os();
            if (this.Os.jh()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.MGA, "6")) {
                if (this.Os.Yw() && !TextUtils.isEmpty(this.Os.qyC())) {
                    this.kb = new com.bytedance.sdk.component.adexpress.MGA.nGm(this.eli, com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(this.Os.qyC()));
                } else {
                    this.kb = new com.bytedance.sdk.component.adexpress.MGA.nGm(this.eli, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.eli);
                frameLayout.addView(this.kb, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Os.FC.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FC.this.kb.DbA();
                    }
                });
            }
            if (eli(this.MGA) && com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                int parseColor = Color.parseColor("#99000000");
                if (this.Os.Yw() && !TextUtils.isEmpty(this.Os.qyC())) {
                    try {
                        parseColor = com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(this.Os.qyC());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.eli);
                view.setBackgroundColor(parseColor);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.ui.Os());
            eli(this.ui.Os());
            setVisibility(0);
        }
    }

    private boolean eli(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.wC instanceof com.bytedance.sdk.component.adexpress.dynamic.Os.eli.Os) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void eli(ViewGroup viewGroup) {
        if (this.aGH == null) {
            return;
        }
        String str = this.MGA;
        str.hashCode();
        switch (str) {
            case "0":
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.ui(this, this.FC);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case "1":
            case "6":
                if (!this.Os.Yw() || TextUtils.isEmpty(this.Os.qyC())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.MGA(this);
                break;
            case "2":
            case "7":
                setBackgroundColor(Color.parseColor("#80000000"));
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.DbA(this, this);
                break;
            case "5":
                if (this.Os.Yw() && !TextUtils.isEmpty(this.Os.qyC())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.aGH.kb.eli(this.Os.qyC()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.Os(this);
                this.aGH.setTag(2);
                break;
            case "8":
            case "11":
                this.DbA.setClipChildren(false);
                this.DbA.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.DbA.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.MGA(this);
                break;
            case "9":
            case "17":
                this.aGH.setTag(2);
                break;
            case "10":
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.aGH(this, this.FC, this.aAs);
                break;
            case "12":
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.Os(this);
                this.aGH.setTag(2);
                break;
            case "13":
            case "24":
                if (this.MGA.equals("24") && com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    this.DbA.setClipChildren(false);
                    this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.MGA(this);
                    break;
                } else {
                    this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.ui(this, this.FC);
                    break;
                }
            case "14":
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.DbA(this, this);
                break;
            case "16":
                View view = this.aGH;
                if (view != null && (view instanceof com.bytedance.sdk.component.adexpress.MGA.QX) && ((com.bytedance.sdk.component.adexpress.MGA.QX) view).getShakeLayout() != null) {
                    ((com.bytedance.sdk.component.adexpress.MGA.QX) this.aGH).getShakeLayout().setTag(2);
                }
                this.aGH.setTag(2);
                break;
            case "18":
                View view2 = this.aGH;
                if (view2 != null && (view2 instanceof ujq) && ((ujq) view2).getWriggleLayout() != null) {
                    ((ujq) this.aGH).getWriggleLayout().setTag(2);
                }
                this.aGH.setTag(2);
                break;
            case "20":
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.eli(this, this.FC, viewGroup);
                break;
            case "22":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.wC(this, this.aAs);
                    break;
                } else {
                    this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.kb(this, this.FC, viewGroup);
                    break;
                }
            case "23":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.MGA(this);
                    break;
                }
                break;
            case "25":
                if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                    this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.wC(this, this.aAs);
                    break;
                }
                break;
            case "29":
                View view3 = this.aGH;
                if (view3 != null && (view3 instanceof com.bytedance.sdk.component.adexpress.MGA.MGA) && ((com.bytedance.sdk.component.adexpress.MGA.MGA) view3).getShakeView() != null) {
                    ((com.bytedance.sdk.component.adexpress.MGA.MGA) this.aGH).getShakeView().setTag(2);
                }
                this.wC = new com.bytedance.sdk.component.adexpress.dynamic.Os.eli.ui(this, this.FC);
                break;
        }
        View.OnTouchListener onTouchListener = this.wC;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (wC()) {
            this.aGH.setTag(2);
            setOnClickListener((View.OnClickListener) this.DbA.getDynamicClickListener());
        }
    }

    private boolean wC() {
        return (this.Os.rQ() || TextUtils.equals("9", this.MGA) || TextUtils.equals("16", this.MGA) || TextUtils.equals("17", this.MGA) || TextUtils.equals("18", this.MGA) || TextUtils.equals("20", this.MGA) || TextUtils.equals("29", this.MGA) || TextUtils.equals("10", this.MGA)) ? false : true;
    }

    public void Os() {
        kb kbVar = this.ui;
        if (kbVar != null) {
            kbVar.eli();
        }
    }

    public void aGH() {
        kb kbVar = this.ui;
        if (kbVar != null) {
            kbVar.DbA();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            kb kbVar = this.ui;
            if (kbVar != null) {
                kbVar.DbA();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void ui() {
        if (this.aGH != null && TextUtils.equals(this.MGA, "2")) {
            View view = this.aGH;
            if (view instanceof com.bytedance.sdk.component.adexpress.MGA.Os) {
                ((com.bytedance.sdk.component.adexpress.MGA.Os) view).Os();
            }
        }
    }

    public void MGA() {
        if (this.aGH != null && TextUtils.equals(this.MGA, "2")) {
            View view = this.aGH;
            if (view instanceof com.bytedance.sdk.component.adexpress.MGA.Os) {
                ((com.bytedance.sdk.component.adexpress.MGA.Os) view).aGH();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.wC
    public void eli() {
        if (TextUtils.equals(this.MGA, "6")) {
            com.bytedance.sdk.component.adexpress.MGA.nGm ngm = this.kb;
            if (ngm != null) {
                ngm.Os();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Os.FC.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FC.this.FC();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.MGA, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Os.FC.3
                @Override // java.lang.Runnable
                public void run() {
                    FC.this.FC();
                }
            }, 400L);
        } else {
            FC();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Os.wC
    public void DbA() {
        if (wC()) {
            setOnClickListener((View.OnClickListener) this.DbA.getDynamicClickListener());
            performClick();
            if (this.Os.yKf()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        if (this.wC != null) {
            setOnClickListener((View.OnClickListener) this.DbA.getDynamicClickListener());
            performClick();
            if (this.Os.yKf()) {
                return;
            }
            setVisibility(8);
        }
    }
}
