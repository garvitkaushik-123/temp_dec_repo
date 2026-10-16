package com.bytedance.sdk.openadsdk.core.nlS.DbA;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.nGm;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.du;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class aGH extends ui {
    private int BDs;
    private int BH;
    private final int Ca;
    private ColorStateList DE;
    private TextView FS;
    private float GMY;
    private float Gjg;
    private float HN;
    private final Rect Hm;
    private float Kp;
    private final Rect MQ;
    private final Rect Mc;
    private final int PfW;
    private TextView QI;
    private TextView SSo;
    private TextView TfR;
    private TextView Uv;
    private View WfR;
    private ColorStateList XU;
    private final Rect XxP;
    private boolean Yw;
    private View Za;
    private TextView cyF;
    private View dZ;
    private int eEH;
    private ImageView eU;
    private float gAc;
    private int gHb;
    private ImageView ikX;
    private ColorStateList iuv;
    private ImageView jh;
    private ImageView mm;
    private final Ue oc;
    private SeekBar ow;
    private int qyC;
    private final Rect rH;
    private boolean rQ;
    private final View.OnTouchListener rn;
    private TextView tGZ;
    private int tLO;
    private final nGm yKf;

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui, com.bykv.vk.openvk.eli.eli.eli.aGH.DbA
    public /* bridge */ /* synthetic */ void eli(Object obj, WeakReference weakReference, boolean z) {
        eli((ev) obj, (WeakReference<Context>) weakReference, z);
    }

    public aGH(Context context, ViewGroup viewGroup, boolean z, int i, ev evVar, com.bykv.vk.openvk.eli.eli.eli.aGH.Os os, boolean z2) {
        super(context, viewGroup, z, i, evVar, os, z2);
        this.oc = new Ue(this);
        this.rQ = false;
        this.Yw = false;
        this.qyC = 0;
        this.BH = 0;
        this.BDs = 0;
        this.tLO = 0;
        this.gHb = 0;
        this.Mc = new Rect();
        this.rH = new Rect();
        this.eEH = 0;
        this.rn = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.aGH.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (actionMasked == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        };
        this.MQ = new Rect();
        this.Hm = new Rect();
        this.XxP = new Rect();
        this.ujq = dV.eli().getApplicationContext();
        aGH(z2);
        this.Os = viewGroup;
        this.bf = z;
        nGm ngm = new nGm(this);
        this.yKf = ngm;
        ngm.eli(this.bf);
        DisplayMetrics displayMetrics = this.ujq.getResources().getDisplayMetrics();
        this.PfW = displayMetrics.widthPixels;
        this.Ca = displayMetrics.heightPixels;
        this.Vy = i;
        this.oWW = os;
        this.gG = evVar;
        aGH(8);
        eli(context, this.Os);
        aGH();
        nlS();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    protected void eli(Context context, View view) {
        super.eli(context, view);
        this.cyF = (TextView) view.findViewById(aqO.pu);
        this.eU = (ImageView) view.findViewById(aqO.an);
        this.dZ = view.findViewById(aqO.tpZ);
        this.jh = (ImageView) view.findViewById(aqO.ZLD);
        this.SSo = (TextView) view.findViewById(aqO.lYL);
        this.Uv = (TextView) view.findViewById(aqO.ID);
        this.FS = (TextView) view.findViewById(aqO.bU);
        this.Za = view.findViewById(aqO.SjY);
        this.ikX = (ImageView) view.findViewById(aqO.TiA);
        TextView textView = (TextView) view.findViewById(aqO.dM);
        this.tGZ = textView;
        textView.setText(com.bytedance.sdk.component.utils.ev.eli(context, "tt_video_retry_des_txt"));
        this.ow = (SeekBar) view.findViewById(aqO.umh);
        this.TfR = (TextView) view.findViewById(aqO.cvo);
        this.QI = (TextView) view.findViewById(aqO.lkd);
        this.WfR = view.findViewById(aqO.GMu);
        this.mm = (ImageView) view.findViewById(aqO.Daf);
        this.FC = view.findViewById(aqO.Tju);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    protected void aGH() {
        super.aGH();
        this.yKf.eli(this.Os);
        SSo.eli((View) this.eU, (this.bf || (this.Vy & 1) == 1) ? 8 : 0);
        this.eU.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.aGH.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aGH.this.aqO()) {
                    aGH.this.KM.Os(aGH.this, view);
                }
            }
        });
        SSo.eli((View) this.cyF, (!this.bf || (this.Vy & 2) == 2) ? 0 : 8);
        this.cyF.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.aGH.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aGH.this.aqO()) {
                    aGH.this.KM.aGH(aGH.this, view);
                }
            }
        });
        this.jh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.aGH.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aGH.this.aqO()) {
                    aGH.this.KM.ui(aGH.this, view);
                }
            }
        });
        this.ikX.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.aGH.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aGH.this.DbA(false, true);
                aGH.this.wC();
                aGH.this.kb();
                aGH.this.aqO();
            }
        });
        this.mm.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.aGH.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aGH.this.aqO()) {
                    aGH.this.KM.DbA(aGH.this, view);
                }
            }
        });
        this.ow.setThumbOffset(0);
        this.ow.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.aGH.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!aGH.this.rQ && aGH.this.ujq != null) {
                    seekBar.setThumb(du.eli(dV.eli(), "tt_seek_thumb_normal"));
                }
                if (aGH.this.aqO()) {
                    seekBar.setThumbOffset(0);
                    aGH.this.KM.eli(aGH.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!aGH.this.rQ && aGH.this.ujq != null) {
                    seekBar.setThumb(du.eli(dV.eli(), "tt_seek_thumb_press"));
                }
                if (aGH.this.aqO()) {
                    seekBar.setThumbOffset(0);
                    aGH.this.KM.DbA(aGH.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (aGH.this.aqO()) {
                    aGH.this.KM.eli(aGH.this, i, z);
                }
            }
        });
        this.ow.setOnTouchListener(this.rn);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void ui() {
        this.oc.removeMessages(1);
        this.oc.sendMessageDelayed(this.oc.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void MGA() {
        this.oc.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void DbA(boolean z) {
        int i = aAs() ? this.Ca : this.dV;
        int i2 = aAs() ? this.PfW : this.nGm;
        if (this.Xb <= 0 || this.QX <= 0 || i <= 0) {
            return;
        }
        if (!bf() && !aAs() && (this.Vy & 8) != 8) {
            i2 = SSo.DbA(this.ujq, 228.0f);
        }
        int i3 = (int) (this.Xb * ((i * 1.0f) / this.QX));
        if (i3 > i2) {
            i = (int) (this.QX * ((i2 * 1.0f) / this.Xb));
        } else {
            i2 = i3;
        }
        if (!z && !aAs()) {
            i = this.dV;
            i2 = this.nGm;
        }
        this.aGH.eli(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(String str) {
        TextView textView = this.SSo;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.Uv;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(int i) {
        View view = this.WfR;
        if (view == null || view.getVisibility() != 0) {
            this.ow.setProgress(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(long j, long j2) {
        this.TfR.setText(com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(j2));
        this.QI.setText(com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(j));
        this.ow.setProgress(com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void kb() {
        SSo.MGA(this.MGA);
        SSo.MGA(this.kb);
        SSo.ui(this.Za);
        if (this.wC != null && this.gG != null && this.gG.nY() != null && this.gG.nY().aAs() != null) {
            SSo.MGA(this.wC);
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.gG.nY().aAs(), this.gG.nY().Os(), this.gG.nY().DbA(), this.wC, this.gG);
        }
        if (this.ui.getVisibility() == 0) {
            SSo.eli((View) this.ui, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui, com.bykv.vk.openvk.eli.eli.eli.aGH.DbA
    public void eli() {
        eli(false, this.bf);
        QX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(long j) {
        this.QI.setText(com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(j));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(ev evVar, WeakReference<Context> weakReference, boolean z) {
        String str;
        String eli;
        if (evVar == null) {
            return;
        }
        eli(this.Os, dV.eli());
        eli(false, this.bf);
        SSo.eli(this.aAs, 0);
        SSo.eli((View) this.du, 0);
        SSo.eli(this.nlS, 0);
        if (this.du != null && this.gG != null && this.gG.nY() != null && this.gG.nY().aAs() != null) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.gG.nY().aAs(), this.gG.nY().Os(), this.gG.nY().DbA(), this.du, this.gG);
        }
        if (!TextUtils.isEmpty(evVar.kEI())) {
            str = evVar.kEI();
        } else if (!TextUtils.isEmpty(evVar.Pf())) {
            str = evVar.Pf();
        } else if (TextUtils.isEmpty(evVar.bU())) {
            str = "";
        } else {
            str = evVar.bU();
        }
        if (this.gG != null && this.gG.SjY() != null && this.gG.SjY().eli() != null) {
            SSo.eli((View) this.NU, 0);
            SSo.eli((View) this.nn, 4);
            if (this.NU != null) {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.gG.SjY(), this.NU, evVar);
                this.NU.setOnClickListener(this.qj);
                this.NU.setOnTouchListener(this.qj);
            }
        } else if (!TextUtils.isEmpty(str)) {
            SSo.eli((View) this.NU, 4);
            SSo.eli((View) this.nn, 0);
            if (this.nn != null) {
                this.nn.setText(str.substring(0, 1));
                this.nn.setOnClickListener(this.qj);
                this.nn.setOnTouchListener(this.qj);
            }
        }
        if (this.Dfc != null && !TextUtils.isEmpty(str)) {
            this.Dfc.setText(str);
        }
        SSo.eli((View) this.Dfc, 0);
        SSo.eli((View) this.aqO, 0);
        int yw = evVar.yw();
        if (yw == 4) {
            eli = com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_video_download_apk");
        } else if (yw == 5) {
            eli = com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_video_dial_phone");
        } else {
            eli = com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_video_mobile_go_detail");
        }
        if (this.aqO != null) {
            this.aqO.setText(eli);
            this.aqO.setOnClickListener(this.qj);
            this.aqO.setOnTouchListener(this.qj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void wC() {
        SSo.ui(this.MGA);
        SSo.ui(this.Za);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void FC() {
        this.ow.setProgress(0);
        this.ow.setSecondaryProgress(0);
        this.TfR.setText(com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_00_00"));
        this.QI.setText(com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_00_00"));
        aGH(8);
        if (Vy()) {
            this.aGH.setVisibility(8);
        }
        if (this.wC != null) {
            this.wC.setImageDrawable(null);
        }
        aGH(8);
        SSo.eli(this.WfR, 8);
        SSo.eli(this.aAs, 8);
        SSo.eli((View) this.du, 8);
        SSo.eli(this.nlS, 8);
        SSo.eli((View) this.NU, 8);
        SSo.eli((View) this.nn, 8);
        SSo.eli((View) this.Dfc, 8);
        if (this.Ue != null) {
            this.Ue.eli(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui, com.bytedance.sdk.openadsdk.core.widget.QX.DbA
    public boolean aAs() {
        return this.rQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(ViewGroup viewGroup) {
        if (viewGroup != null && (this.Os.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.rQ = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Os.getLayoutParams();
            this.BH = marginLayoutParams.leftMargin;
            this.qyC = marginLayoutParams.topMargin;
            this.BDs = marginLayoutParams.width;
            this.tLO = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.Os.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.gHb = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.Mc.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                SSo.eli(viewGroup, 0, 0, 0, 0);
            }
            DbA(true);
            this.mm.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this.ujq, "tt_shrink_video"));
            this.ow.setThumb(du.eli(this.ujq, "tt_seek_thumb_fullscreen_selector"));
            this.ow.setThumbOffset(0);
            com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli((View) this.Os, false);
            ui(this.rQ);
            SSo.eli(this.dZ, 8);
            if (!this.bf) {
                SSo.eli((View) this.eU, 8);
                SSo.eli((View) this.cyF, 8);
            } else if ((this.Vy & 1) == 1) {
                SSo.eli((View) this.eU, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void DbA(ViewGroup viewGroup) {
        if (viewGroup == null || this.Os == null || !(this.Os.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.rQ = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Os.getLayoutParams();
        marginLayoutParams.width = this.BDs;
        marginLayoutParams.height = this.tLO;
        marginLayoutParams.leftMargin = this.BH;
        marginLayoutParams.topMargin = this.qyC;
        this.Os.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.gHb);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            SSo.eli(viewGroup, this.Mc.left, this.Mc.top, this.Mc.right, this.Mc.bottom);
        }
        DbA(true);
        this.mm.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this.ujq, "tt_enlarge_video"));
        this.ow.setThumb(du.eli(this.ujq, "tt_seek_thumb_normal"));
        this.ow.setThumbOffset(0);
        com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli((View) this.Os, true);
        ui(this.rQ);
        SSo.eli(this.dZ, 8);
        if ((this.Vy & 2) == 2) {
            SSo.eli((View) this.cyF, 0);
        }
    }

    private void ui(boolean z) {
        if (z) {
            gG();
        } else {
            ujq();
        }
    }

    private void gG() {
        DisplayMetrics displayMetrics = this.ujq.getResources().getDisplayMetrics();
        TextView textView = this.QI;
        if (textView != null) {
            this.Gjg = textView.getTextSize();
            this.QI.setTextSize(2, 14.0f);
            ColorStateList textColors = this.QI.getTextColors();
            this.XU = textColors;
            if (textColors != null) {
                this.QI.setTextColor(-1);
            }
            this.Kp = this.QI.getAlpha();
            this.QI.setAlpha(0.85f);
            this.QI.setShadowLayer(0.0f, SSo.DbA(this.ujq, 0.5f), SSo.DbA(this.ujq, 0.5f), com.bytedance.sdk.component.utils.ev.kb(this.ujq, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams = this.QI.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.MQ.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                SSo.eli(this.QI, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.MQ.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.MQ.bottom);
            }
        }
        TextView textView2 = this.TfR;
        if (textView2 != null) {
            this.gAc = textView2.getTextSize();
            this.TfR.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.TfR.getTextColors();
            this.iuv = textColors2;
            if (textColors2 != null) {
                this.TfR.setTextColor(-1);
            }
            this.HN = this.TfR.getAlpha();
            this.TfR.setAlpha(0.85f);
            this.TfR.setShadowLayer(0.0f, SSo.DbA(this.ujq, 0.5f), SSo.DbA(this.ujq, 0.5f), com.bytedance.sdk.component.utils.ev.kb(this.ujq, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams2 = this.TfR.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.Hm.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                SSo.eli(this.TfR, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.Hm.top, this.Hm.right, this.Hm.bottom);
            }
        }
        ImageView imageView = this.mm;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.XxP.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                SSo.eli(this.mm, this.XxP.left, this.XxP.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.XxP.bottom);
            }
        }
        ImageView imageView2 = this.mm;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this.ujq, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.Uv;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.DE = textColors3;
            if (textColors3 != null) {
                this.Uv.setTextColor(-1);
            }
            this.GMY = this.Uv.getAlpha();
            this.Uv.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.Uv.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.rH.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                SSo.eli(this.Uv, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.Hm.top, this.Hm.right, this.Hm.bottom);
            }
        }
        View view = this.dZ;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.eEH = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.dZ.setLayoutParams(layoutParams5);
            this.dZ.setBackgroundResource(com.bytedance.sdk.component.utils.ev.aGH(this.ujq, "tt_shadow_fullscreen_top"));
        }
        DbA(false, true);
    }

    private void ujq() {
        TextView textView = this.QI;
        if (textView != null) {
            textView.setTextSize(0, this.Gjg);
            ColorStateList colorStateList = this.XU;
            if (colorStateList != null) {
                this.QI.setTextColor(colorStateList);
            }
            this.QI.setAlpha(this.Kp);
            this.QI.setShadowLayer(SSo.DbA(this.ujq, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.ev.kb(this.ujq, "tt_72000000"));
            SSo.eli(this.QI, this.MQ.left, this.MQ.top, this.MQ.right, this.MQ.bottom);
        }
        TextView textView2 = this.TfR;
        if (textView2 != null) {
            textView2.setTextSize(0, this.gAc);
            ColorStateList colorStateList2 = this.iuv;
            if (colorStateList2 != null) {
                this.TfR.setTextColor(colorStateList2);
            }
            this.TfR.setAlpha(this.HN);
            this.TfR.setShadowLayer(SSo.DbA(this.ujq, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.ev.kb(this.ujq, "tt_72000000"));
            SSo.eli(this.TfR, this.Hm.left, this.Hm.top, this.Hm.right, this.Hm.bottom);
        }
        ImageView imageView = this.mm;
        if (imageView != null) {
            SSo.eli(imageView, this.XxP.left, this.XxP.top, this.XxP.right, this.XxP.bottom);
        }
        ImageView imageView2 = this.mm;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this.ujq, "tt_enlarge_video"));
        }
        TextView textView3 = this.Uv;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.DE;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.Uv.setAlpha(this.GMY);
            SSo.eli(this.Uv, this.Hm.left, this.Hm.top, this.Hm.right, this.Hm.bottom);
        }
        View view = this.dZ;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.eEH;
            this.dZ.setLayoutParams(layoutParams);
            this.dZ.setBackground(du.eli(this.ujq, "tt_video_black_desc_gradient"));
        }
        DbA(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui, com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message.what != 1) {
            return;
        }
        du();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(boolean z, boolean z2, boolean z3) {
        SSo.eli(this.WfR, 0);
        if (this.rQ) {
            SSo.eli(this.dZ, 0);
            SSo.eli((View) this.Uv, 0);
        } else if (z3) {
            SSo.eli(this.dZ, 8);
        }
        SSo.eli((View) this.ui, (!z || this.MGA.getVisibility() == 0) ? 8 : 0);
        if (!this.bf && !this.rQ) {
            if ((this.Vy & 1) != 1 && !z3) {
                SSo.eli((View) this.eU, 0);
            }
            SSo.eli((View) this.cyF, z3 ? 8 : 0);
        }
        SSo.eli((View) this.TfR, 0);
        SSo.eli((View) this.QI, 0);
        SSo.eli((View) this.ow, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void eli(boolean z, boolean z2) {
        SSo.eli(this.WfR, 8);
        SSo.eli(this.dZ, 8);
        SSo.eli((View) this.ui, 8);
        if (!this.bf && !this.rQ) {
            SSo.eli((View) this.eU, 8);
            if ((this.Vy & 2) != 2) {
                SSo.eli((View) this.cyF, 8);
            }
        } else if ((this.Vy & 1) == 1) {
            SSo.eli((View) this.eU, 8);
        }
        if (z2) {
            SSo.eli((View) this.eU, 8);
            SSo.eli((View) this.cyF, 8);
        }
        Os(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui, com.bytedance.sdk.openadsdk.core.widget.QX.DbA
    public void du() {
        eli(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public boolean DbA(int i) {
        SeekBar seekBar = this.ow;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui
    public void Os(boolean z) {
        TextView textView;
        TextView textView2;
        int i;
        if (this.SSo != null) {
            if (this.bf) {
                textView2 = this.SSo;
            } else {
                textView = this.SSo;
                if (z) {
                    i = 0;
                    SSo.eli((View) textView, i);
                }
                textView2 = textView;
            }
            textView = textView2;
            i = 8;
            SSo.eli((View) textView, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.ui, com.bytedance.sdk.openadsdk.core.widget.nGm.eli
    public void eli(View view, boolean z) {
        if (aAs()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.gG != null && !TextUtils.isEmpty(this.gG.Pf())) {
                eli(this.gG.Pf());
            }
            this.FS.setText(format);
        } else {
            eli("");
            this.FS.setText("");
        }
        if (this.VM) {
            return;
        }
        Os(this.bf && !this.rQ);
        if (aqO()) {
            this.KM.eli(this, view, true, this.MGA.getVisibility() != 0);
        }
    }
}
