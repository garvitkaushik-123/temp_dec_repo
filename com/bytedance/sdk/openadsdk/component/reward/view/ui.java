package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.aqO;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui extends com.bytedance.sdk.openadsdk.core.ui.ui {
    private TextView DbA;
    private TextView MGA;
    private TextView Os;
    private dV aGH;
    private aqO eli;
    private boolean kb;
    private TextView ui;
    private com.bytedance.sdk.openadsdk.component.reward.eli.eli wC;

    public ui(Context context) {
        super(context);
        setOrientation(1);
        setVisibility(8);
        setBackgroundColor(-1);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0 || this.kb) {
            return;
        }
        aGH();
    }

    private void aGH() {
        this.kb = true;
        ev evVar = this.wC.DbA;
        int mm = evVar.mm();
        if ((mm == 43 || mm == 44) && KM.DbA(evVar)) {
            Os();
        } else if (this.wC.QI == 1) {
            MGA();
        } else {
            ui();
        }
        if (this.DbA == null) {
            this.DbA = (TextView) this.wC.dZ.findViewById(520093705);
        }
        TextView textView = this.DbA;
        if (textView != null) {
            textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.ui.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int width = ((ViewGroup) ui.this.DbA.getParent()).getWidth();
                    if (width > 0) {
                        ui.this.DbA.setMaxWidth((int) (width * 0.45f));
                    }
                }
            });
            if (evVar.Kv()) {
                if (evVar.io() != null && TextUtils.isEmpty(evVar.io().MGA())) {
                    SSo.eli((View) this.DbA, 8);
                }
            } else {
                this.DbA.setText(evVar.rn() == 3 ? getButtonTextForNewStyleBar() : evVar.GMu());
            }
        }
        if (this.aGH != null && evVar.SjY() != null && !TextUtils.isEmpty(evVar.SjY().eli())) {
            String eli2 = evVar.SjY().eli();
            if (evVar.Kv()) {
                com.bytedance.sdk.openadsdk.FC.aGH.eli(evVar.SjY()).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, evVar.SjY().eli(), new eli(this.aGH, evVar, eli2, this.wC.ui)));
                if (evVar.io() != null && evVar.io().DbA() != null) {
                    evVar.io().DbA().DbA(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(evVar.SjY(), this.aGH, evVar);
            }
        }
        TextView textView2 = this.ui;
        if (textView2 != null) {
            textView2.setText(evVar.Pf());
        }
        TextView textView3 = this.MGA;
        if (textView3 != null) {
            textView3.setText(eli(evVar));
        }
        if (this.Os != null) {
            String gG = KM.gG(this.wC.DbA);
            if (TextUtils.isEmpty(gG)) {
                gG = "Play now";
            }
            this.Os.setText(gG);
            this.Os.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.ui.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ui.this.wC != null) {
                        com.bytedance.sdk.openadsdk.component.reward.eli.eli(ui.this.wC);
                    }
                }
            });
        }
        aqO aqo = this.eli;
        if (aqo != null) {
            SSo.eli((TextView) null, aqo, evVar);
        }
        if (this.wC.QI == 2 && evVar.rn() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.DbA.getLayoutParams();
            layoutParams.height = SSo.DbA(this.wC.FS, 55.0f);
            layoutParams.topMargin = SSo.DbA(this.wC.FS, 20.0f);
            this.DbA.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams2.bottomMargin = SSo.DbA(this.wC.FS, 12.0f);
            setLayoutParams(layoutParams2);
        }
        DbA();
    }

    private String eli(ev evVar) {
        if (!TextUtils.isEmpty(evVar.Pf())) {
            return evVar.Pf();
        }
        if (!TextUtils.isEmpty(evVar.bU())) {
            return evVar.bU();
        }
        return "";
    }

    private void ui() {
        setOrientation(0);
        setGravity(16);
        Context context = getContext();
        setPadding(SSo.DbA(context, 16.0f), SSo.DbA(context, 12.0f), SSo.DbA(context, 16.0f), SSo.DbA(context, 12.0f));
        dV dVVar = new dV(context);
        this.aGH = dVVar;
        dVVar.setBackgroundColor(0);
        this.aGH.setId(com.bytedance.sdk.openadsdk.utils.aqO.DbA);
        addView(this.aGH, new LinearLayout.LayoutParams(SSo.DbA(context, 48.0f), SSo.DbA(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = SSo.DbA(context, 12.0f);
        layoutParams.weight = 1.0f;
        addView(uiVar, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.ui = wCVar;
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        this.ui.setGravity(16);
        this.ui.setSingleLine(true);
        this.ui.setTextSize(2, 17.0f);
        this.ui.setId(com.bytedance.sdk.openadsdk.utils.aqO.Os);
        this.ui.setTextColor(-16777216);
        uiVar.addView(this.ui, new LinearLayout.LayoutParams(-1, -2));
        aqO aqo = new aqO(context);
        this.eli = aqo;
        aqo.setId(com.bytedance.sdk.openadsdk.utils.aqO.ui);
        uiVar.addView(this.eli, new LinearLayout.LayoutParams(-2, SSo.DbA(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.DbA = wCVar2;
        wCVar2.setGravity(17);
        this.DbA.setEllipsize(TextUtils.TruncateAt.END);
        this.DbA.setSingleLine(true);
        this.DbA.setTextColor(-1);
        this.DbA.setTextSize(2, 16.0f);
        this.DbA.setId(520093705);
        this.DbA.setBackground(eli(context));
        this.DbA.setText(this.wC.DbA.GMu());
        addView(this.DbA, new LinearLayout.LayoutParams(SSo.DbA(context, 164.0f), SSo.DbA(context, 36.0f)));
    }

    public void eli() {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.start();
    }

    public void eli(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.wC = eliVar;
        if (eliVar.DbA.rn() == 1) {
            aGH();
        }
    }

    protected String getButtonTextForNewStyleBar() {
        boolean z;
        String GMu;
        String Os = dZ.Os(this.wC.FS);
        if (Os == null) {
            Os = "";
        }
        try {
            z = Os.equals(Locale.ENGLISH.getLanguage());
        } catch (Throwable unused) {
            z = false;
        }
        if (TextUtils.isEmpty(this.wC.DbA.GMu())) {
            GMu = this.wC.DbA.yw() != 4 ? "View" : LayoutConfigDefaults.CTA_TEXT;
        } else {
            GMu = this.wC.DbA.GMu();
            if (GMu == null || !dZ.MGA(GMu) || GMu.length() <= 2) {
                if (GMu != null && !dZ.MGA(GMu) && GMu.length() > 7 && z) {
                    GMu = getCnOrEnBtnText();
                }
            } else if (z) {
                GMu = getCnOrEnBtnText();
            }
        }
        if (z && !dZ.MGA(GMu)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.DbA.getLayoutParams();
            layoutParams.bottomMargin = SSo.DbA(this.wC.FS, 4.0f);
            this.DbA.setLayoutParams(layoutParams);
        }
        return GMu;
    }

    private String getCnOrEnBtnText() {
        if (this.wC.DbA.yw() != 4) {
            return "View";
        }
        return LayoutConfigDefaults.CTA_TEXT;
    }

    public void DbA() {
        com.bytedance.sdk.openadsdk.core.DbA.ui ui = this.wC.KM.ui();
        final com.bytedance.sdk.openadsdk.core.DbA.DbA aGH = this.wC.KM.aGH();
        final ev evVar = this.wC.DbA;
        if (evVar.Gjg() == null) {
            return;
        }
        if (evVar.rn() != 5 && this.DbA != null) {
            if (evVar.Gjg().ui) {
                this.DbA.setOnClickListener(ui);
                this.DbA.setOnTouchListener(ui);
            } else {
                this.DbA.setOnClickListener(aGH);
            }
        }
        if (evVar.rn() == 1) {
            if (evVar.Gjg().eli) {
                SSo.eli((View) this, (View.OnClickListener) ui, "TTBaseVideoActivity#mRlDownloadBar");
                SSo.eli((View) this, (View.OnTouchListener) ui, "TTBaseVideoActivity#mRlDownloadBar");
                this.ui.setOnClickListener(ui);
                this.ui.setOnTouchListener(ui);
                this.eli.setOnClickListener(ui);
                this.eli.setOnTouchListener(ui);
                this.aGH.setOnClickListener(ui);
                this.aGH.setOnTouchListener(ui);
                return;
            }
            SSo.eli((View) this, (View.OnClickListener) aGH, "TTBaseVideoActivity#mRlDownloadBar");
            this.ui.setOnClickListener(aGH);
            this.eli.setOnClickListener(aGH);
            this.aGH.setOnClickListener(aGH);
            return;
        }
        if (evVar.rn() == 5) {
            String str = "VAST_ICON";
            if (evVar.Gjg().ui) {
                com.bytedance.sdk.openadsdk.core.DbA.kb kbVar = new com.bytedance.sdk.openadsdk.core.DbA.kb("VAST_ACTION_BUTTON", evVar.io(), ui) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.ui.3
                };
                com.bytedance.sdk.openadsdk.core.DbA.kb kbVar2 = new com.bytedance.sdk.openadsdk.core.DbA.kb(str, evVar.io(), ui) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.ui.4
                };
                TextView textView = this.DbA;
                if (textView != null) {
                    textView.setOnClickListener(kbVar);
                    this.DbA.setOnTouchListener(kbVar);
                }
                dV dVVar = this.aGH;
                if (dVVar != null) {
                    dVVar.setOnClickListener(kbVar2);
                    this.aGH.setOnTouchListener(kbVar2);
                }
                TextView textView2 = this.ui;
                if (textView2 == null || TextUtils.isEmpty(textView2.getText())) {
                    return;
                }
                this.ui.setOnClickListener(kbVar);
                this.ui.setOnTouchListener(kbVar);
                return;
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.ui.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    View.OnClickListener onClickListener2 = aGH;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                    }
                    if (view != null && "VAST_ICON".equals(view.getTag(570425345))) {
                        if (evVar.io() == null || evVar.io().DbA() == null) {
                            return;
                        }
                        evVar.io().DbA().eli(ui.this.wC.ev.nlS());
                        return;
                    }
                    if (evVar.io() != null) {
                        evVar.io().eli().kb(ui.this.wC.ev.nlS());
                    }
                }
            };
            TextView textView3 = this.DbA;
            if (textView3 != null) {
                textView3.setOnClickListener(onClickListener);
            }
            TextView textView4 = this.ui;
            if (textView4 != null && !TextUtils.isEmpty(textView4.getText())) {
                this.ui.setOnClickListener(onClickListener);
            }
            dV dVVar2 = this.aGH;
            if (dVVar2 != null) {
                dVVar2.setTag(570425345, "VAST_ICON");
                this.aGH.setOnClickListener(aGH);
                return;
            }
            return;
        }
        if (evVar.Gjg().Os) {
            SSo.eli((View) this, (View.OnClickListener) ui, "TTBaseVideoActivity#mRlDownloadBar");
            SSo.eli((View) this, (View.OnTouchListener) ui, "TTBaseVideoActivity#mRlDownloadBar");
        } else {
            SSo.eli((View) this, (View.OnClickListener) aGH, "TTBaseVideoActivity#mRlDownloadBar");
        }
    }

    private void MGA() {
        Context context = getContext();
        setPadding(SSo.DbA(context, 16.0f), SSo.DbA(context, 16.0f), SSo.DbA(context, 16.0f), SSo.DbA(context, 24.0f));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(0);
        uiVar.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = SSo.DbA(context, 12.0f);
        addView(uiVar, layoutParams);
        dV dVVar = new dV(context);
        this.aGH = dVVar;
        dVVar.setBackgroundColor(0);
        this.aGH.setId(com.bytedance.sdk.openadsdk.utils.aqO.DbA);
        uiVar.addView(this.aGH, new LinearLayout.LayoutParams(SSo.DbA(context, 48.0f), SSo.DbA(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = SSo.DbA(context, 12.0f);
        uiVar.addView(uiVar2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.ui = wCVar;
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        this.ui.setGravity(16);
        this.ui.setSingleLine(true);
        this.ui.setTextSize(2, 17.0f);
        this.ui.setId(com.bytedance.sdk.openadsdk.utils.aqO.Os);
        this.ui.setTextColor(-16777216);
        uiVar2.addView(this.ui, new LinearLayout.LayoutParams(-1, -2));
        aqO aqo = new aqO(context);
        this.eli = aqo;
        aqo.setId(com.bytedance.sdk.openadsdk.utils.aqO.ui);
        uiVar2.addView(this.eli, new LinearLayout.LayoutParams(-2, SSo.DbA(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.DbA = wCVar2;
        wCVar2.setGravity(17);
        this.DbA.setEllipsize(TextUtils.TruncateAt.END);
        this.DbA.setSingleLine(true);
        this.DbA.setTextColor(-1);
        this.DbA.setTextSize(2, 16.0f);
        this.DbA.setId(520093705);
        this.DbA.setBackground(eli(context));
        this.DbA.setText(this.wC.DbA.GMu());
        addView(this.DbA, new LinearLayout.LayoutParams(-1, SSo.DbA(context, 36.0f)));
    }

    public void Os() {
        Context context = getContext();
        int DbA = SSo.DbA(context, 12.0f);
        setPadding(DbA, DbA, DbA, DbA);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        uiVar.setOrientation(0);
        uiVar.setGravity(16);
        addView(uiVar, layoutParams);
        dV dVVar = new dV(context);
        this.aGH = dVVar;
        dVVar.setBackgroundColor(0);
        this.aGH.setId(com.bytedance.sdk.openadsdk.utils.aqO.DbA);
        uiVar.addView(this.aGH, new LinearLayout.LayoutParams(SSo.DbA(context, 54.0f), SSo.DbA(context, 54.0f)));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = SSo.DbA(context, 12.0f);
        uiVar.addView(uiVar2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.ui = wCVar;
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        this.ui.setGravity(16);
        this.ui.setSingleLine(true);
        this.ui.setTextSize(2, 17.0f);
        this.ui.setId(com.bytedance.sdk.openadsdk.utils.aqO.Os);
        this.ui.setTextColor(-16777216);
        uiVar2.addView(this.ui, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.MGA = wCVar2;
        wCVar2.setTextColor(-16777216);
        this.MGA.setTextSize(2, 13.0f);
        this.MGA.setMaxLines(2);
        this.MGA.setAlpha(0.8f);
        this.MGA.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = SSo.DbA(context, 4.0f);
        uiVar2.addView(this.MGA, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = SSo.DbA(context, 12.0f);
        uiVar3.setOrientation(0);
        addView(uiVar3, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.Os = wCVar3;
        wCVar3.setGravity(17);
        this.Os.setEllipsize(TextUtils.TruncateAt.END);
        this.Os.setSingleLine(true);
        this.Os.setTextColor(-16777216);
        this.Os.setTextSize(2, 16.0f);
        this.Os.setBackground(DbA(context));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, SSo.DbA(context, 36.0f), 1.0f);
        layoutParams5.rightMargin = SSo.DbA(context, 3.0f);
        uiVar3.addView(this.Os, layoutParams5);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar4 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.DbA = wCVar4;
        wCVar4.setGravity(17);
        this.DbA.setEllipsize(TextUtils.TruncateAt.END);
        this.DbA.setSingleLine(true);
        this.DbA.setTextColor(-1);
        this.DbA.setTextSize(2, 16.0f);
        this.DbA.setId(520093705);
        this.DbA.setBackground(Os(context));
        this.DbA.setText(this.wC.DbA.GMu());
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, SSo.DbA(context, 36.0f), 1.0f);
        layoutParams6.leftMargin = SSo.DbA(context, 3.0f);
        uiVar3.addView(this.DbA, layoutParams6);
    }

    private static Drawable eli(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1A73E8"));
        gradientDrawable.setCornerRadius(SSo.DbA(context, 18.0f));
        return gradientDrawable;
    }

    private static Drawable DbA(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#000000"));
        gradientDrawable.setAlpha(30);
        gradientDrawable.setCornerRadius(SSo.DbA(context, 8.0f));
        return gradientDrawable;
    }

    private static Drawable Os(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FE2C55"));
        gradientDrawable.setCornerRadius(SSo.DbA(context, 8.0f));
        return gradientDrawable;
    }

    private static class eli implements com.bytedance.sdk.component.ui.aqO {
        private final String DbA;
        private final String Os;
        private final WeakReference<ImageView> aGH;
        private final ev eli;

        public eli(ImageView imageView, ev evVar, String str, String str2) {
            this.aGH = new WeakReference<>(imageView);
            this.eli = evVar;
            this.DbA = str;
            this.Os = str2;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(com.bytedance.sdk.component.ui.du duVar) {
            Object DbA = duVar.DbA();
            if (DbA != null) {
                ImageView imageView = this.aGH.get();
                if (DbA instanceof Bitmap) {
                    if (imageView != null) {
                        imageView.setImageBitmap((Bitmap) DbA);
                    }
                } else if (DbA instanceof Drawable) {
                    if (DbA instanceof AnimatedImageDrawable) {
                        ((AnimatedImageDrawable) DbA).start();
                    }
                    if (imageView != null) {
                        imageView.setImageDrawable((Drawable) DbA);
                    }
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.eli, this.Os, "load_vast_icon_success", (JSONObject) null);
            }
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(int i, String str, Throwable th) {
            eli(i, str, this.DbA);
        }

        private void eli(final int i, final String str, final String str2) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(new com.bytedance.sdk.component.wC.wC("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.view.ui.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                        jSONObject.put("description", i + ":" + str);
                        jSONObject.put("url", str2);
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(eli.this.eli, eli.this.Os, "load_vast_icon_fail", jSONObject);
                }
            });
        }
    }
}
