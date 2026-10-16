package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aqO;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RFEndCardBackUpLayout extends com.bytedance.sdk.openadsdk.core.ui.Os {
    private static final String TAG = "TTAD.RFEndCardBackUpL";
    private com.bytedance.sdk.openadsdk.component.reward.eli.eli adContext;
    private PAGLogoView adLogo;
    private dV ivIcon;
    private boolean mInit;
    private aqO rbScore;
    private int shownAdCount;
    private com.bytedance.sdk.openadsdk.core.ui.wC tvDesc;
    private com.bytedance.sdk.openadsdk.core.ui.wC tvDownload;
    private TextView tvTitle;

    public RFEndCardBackUpLayout(Context context) {
        super(context);
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.aqO.MQ);
    }

    public void init(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.adContext = eliVar;
        if (eliVar.DbA.Kv()) {
            initViews();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            initViews();
        }
    }

    private void initViews() {
        if (this.mInit) {
            return;
        }
        this.mInit = true;
        if (this.adContext.DbA.dZ() && this.adContext.yKf != null && this.adContext.yKf.eU() && this.shownAdCount > 1) {
            initOneSlotMultipleAdsLayout();
            return;
        }
        ev evVar = this.adContext.DbA;
        if (evVar.Kv()) {
            initViewsForVast();
        } else {
            initViewsDefault();
            initData(evVar, this.tvDownload);
        }
    }

    private void initData(ev evVar, com.bytedance.sdk.openadsdk.core.ui.wC wCVar) {
        setDownloadButtonData(wCVar, evVar, -1);
        bindIconData(this.ivIcon, evVar);
        aqO aqo = this.rbScore;
        if (aqo != null) {
            SSo.eli((TextView) null, aqo, evVar);
            if (evVar.pu() != null) {
                this.rbScore.setVisibility(0);
            }
        }
        if (this.tvTitle != null) {
            if (evVar.pu() != null && !TextUtils.isEmpty(evVar.pu().DbA())) {
                this.tvTitle.setText(evVar.pu().DbA());
            } else if (!TextUtils.isEmpty(evVar.kEI())) {
                this.tvTitle.setText(evVar.kEI());
            } else {
                this.tvTitle.setVisibility(8);
            }
        }
        if (this.tvDesc != null) {
            String Pf = evVar.Pf();
            if (!TextUtils.isEmpty(Pf)) {
                this.tvDesc.setText(Pf);
            } else {
                this.tvDesc.setVisibility(8);
            }
        }
        this.adLogo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.eli(RFEndCardBackUpLayout.this.adContext.SSo, RFEndCardBackUpLayout.this.adContext.DbA, RFEndCardBackUpLayout.this.adContext.ui);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void bindIconData(com.bytedance.sdk.openadsdk.core.ui.aGH agh, ev evVar) {
        if (agh == null || evVar.SjY() == null || TextUtils.isEmpty(evVar.SjY().eli())) {
            return;
        }
        com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(evVar.SjY(), agh, evVar);
    }

    private void bindTitleData(TextView textView, ev evVar, String str) {
        if (textView != null) {
            if (evVar.pu() != null && !TextUtils.isEmpty(evVar.pu().DbA())) {
                textView.setText(evVar.pu().DbA());
            } else {
                textView.setText(str);
            }
        }
    }

    private void initOneSlotMultipleAdsLayout() {
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#C2FFFFFF"));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(SSo.DbA(context, 16.0f), 0, SSo.DbA(context, 16.0f), 0);
        layoutParams.gravity = 17;
        addView(uiVar, layoutParams);
        if (this.adContext.QI == 2) {
            com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
            uiVar2.setOrientation(0);
            uiVar.addView(uiVar2, new FrameLayout.LayoutParams(-1, -2));
            initOneSlotMultipleAdsLayoutLandscape(uiVar2, this.shownAdCount);
        } else if (this.shownAdCount == 2) {
            initOneSlotMultipleAdsLayoutForTwoAdVertical(uiVar);
        } else {
            initOneSlotMultipleAdsLayoutForThreeAdVertical(uiVar);
        }
        PAGLogoView createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.adContext.SSo, this.adContext.DbA);
        createPAGLogoViewByMaterial.setId(520093757);
        uiVar.addView(createPAGLogoViewByMaterial);
        createPAGLogoViewByMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTWebsiteActivity.eli(RFEndCardBackUpLayout.this.adContext.SSo, RFEndCardBackUpLayout.this.adContext.DbA, RFEndCardBackUpLayout.this.adContext.ui);
            }
        });
    }

    private void initOneSlotMultipleAdsLayoutLandscape(com.bytedance.sdk.openadsdk.core.ui.ui uiVar, int i) {
        if (this.adContext.DbA != null) {
            List<ev> aGH = this.adContext.DbA.Os().aGH();
            for (int i2 = 0; i2 < aGH.size() && i2 < i && i2 < 3; i2++) {
                initSingleCardInTwoCardStyleLandscape(uiVar, aGH.get(i2), i2, i);
            }
        }
    }

    private void initSingleCardInTwoCardStyleLandscape(com.bytedance.sdk.openadsdk.core.ui.ui uiVar, ev evVar, int i, int i2) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar2.setOrientation(1);
        uiVar2.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        if (i > 0) {
            layoutParams.setMargins(SSo.DbA(context, 12.0f), 0, 0, 0);
        }
        uiVar2.setBackground(new eli(context));
        uiVar.addView(uiVar2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar3.setOrientation(0);
        uiVar3.setGravity(48);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = SSo.DbA(context, 20.0f);
        layoutParams2.leftMargin = SSo.DbA(context, 17.0f);
        layoutParams2.rightMargin = SSo.DbA(context, 30.0f);
        uiVar2.addView(uiVar3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.aGH dVVar = new dV(context);
        uiVar3.addView(dVVar, new FrameLayout.LayoutParams(SSo.DbA(context, 44.0f), SSo.DbA(context, 44.0f)));
        bindIconData(dVVar, evVar);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar4 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = SSo.DbA(context, 7.0f);
        uiVar3.addView(uiVar4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setSingleLine(true);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setTextSize(18.0f);
        wCVar.setTextColor(Color.parseColor("#161823"));
        wCVar.setGravity(GravityCompat.START);
        wCVar.setTypeface(null, 1);
        uiVar4.addView(wCVar, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(wCVar, evVar, evVar.kEI());
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar5 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar5.setOrientation(0);
        uiVar5.setGravity(16);
        uiVar4.addView(uiVar5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar2.setTextSize(16.0f);
        wCVar2.setTextColor(Color.parseColor("#80161823"));
        uiVar5.addView(wCVar2, new ViewGroup.LayoutParams(-2, -2));
        aqO aqo = new aqO(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = SSo.DbA(context, 8.0f);
        uiVar5.addView(aqo, layoutParams4);
        SSo.eli(wCVar2, aqo, evVar, 18);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        if (i2 == 2) {
            wCVar3.setSingleLine(true);
        } else {
            wCVar3.setLines(2);
        }
        wCVar3.setEllipsize(TextUtils.TruncateAt.END);
        wCVar3.setTextSize(16.0f);
        wCVar3.setTextColor(Color.parseColor("#80161823"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int i3 = layoutParams2.leftMargin;
        layoutParams5.rightMargin = i3;
        layoutParams5.leftMargin = i3;
        layoutParams5.topMargin = SSo.DbA(context, 12.0f);
        uiVar2.addView(wCVar3, layoutParams5);
        bindDescData(wCVar3, evVar);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar4 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar4.setGravity(17);
        wCVar4.setId(520093707);
        wCVar4.setText(com.bytedance.sdk.component.utils.ev.eli(context, "tt_video_download_apk"));
        wCVar4.setTextColor(-1);
        wCVar4.setTextSize(2, 16.0f);
        wCVar4.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, SSo.DbA(context, 36.0f));
        layoutParams6.setMargins(SSo.DbA(context, 20.0f), SSo.DbA(context, 22.0f), SSo.DbA(context, 20.0f), SSo.DbA(context, 20.0f));
        uiVar2.addView(wCVar4, layoutParams6);
        setDownloadButtonData(wCVar4, evVar, i);
    }

    private void initOneSlotMultipleAdsLayoutForThreeAdVertical(com.bytedance.sdk.openadsdk.core.ui.ui uiVar) {
        if (this.adContext.DbA != null) {
            List<ev> aGH = this.adContext.DbA.Os().aGH();
            for (int i = 0; i < aGH.size() && i < 3; i++) {
                initSingleCardInThreeCardStyle(uiVar, aGH.get(i), i);
            }
        }
    }

    private void initSingleCardInThreeCardStyle(com.bytedance.sdk.openadsdk.core.ui.ui uiVar, ev evVar, int i) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar2.setOrientation(1);
        uiVar2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i > 0 ? SSo.DbA(context, 12.0f) : 0, 0, 0);
        uiVar2.setBackground(new eli(context));
        uiVar.addView(uiVar2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar3.setOrientation(0);
        uiVar3.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = SSo.DbA(context, 20.0f);
        layoutParams2.leftMargin = SSo.DbA(context, 17.0f);
        layoutParams2.rightMargin = SSo.DbA(context, 30.0f);
        uiVar2.addView(uiVar3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.aGH dVVar = new dV(context);
        uiVar3.addView(dVVar, new FrameLayout.LayoutParams(SSo.DbA(context, 70.0f), SSo.DbA(context, 63.0f)));
        bindIconData(dVVar, evVar);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar4 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = SSo.DbA(context, 7.0f);
        uiVar3.addView(uiVar4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setSingleLine(true);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setTextSize(18.0f);
        wCVar.setTextColor(Color.parseColor("#161823"));
        wCVar.setGravity(GravityCompat.START);
        wCVar.setTypeface(null, 1);
        uiVar4.addView(wCVar, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(wCVar, evVar, evVar.kEI());
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar2.setSingleLine(true);
        wCVar2.setEllipsize(TextUtils.TruncateAt.END);
        wCVar2.setTextSize(16.0f);
        wCVar2.setTextColor(Color.parseColor("#80161823"));
        uiVar4.addView(wCVar2, new FrameLayout.LayoutParams(-1, -2));
        bindDescData(wCVar2, evVar);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar5 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar5.setOrientation(0);
        uiVar5.setGravity(16);
        uiVar4.addView(uiVar5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar3.setTextSize(16.0f);
        wCVar3.setTextColor(Color.parseColor("#80161823"));
        uiVar5.addView(wCVar3, new ViewGroup.LayoutParams(-2, -2));
        aqO aqo = new aqO(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = SSo.DbA(context, 8.0f);
        uiVar5.addView(aqo, layoutParams4);
        SSo.eli(wCVar3, aqo, evVar, 18);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar4 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar4.setGravity(17);
        wCVar4.setId(520093707);
        wCVar4.setText(com.bytedance.sdk.component.utils.ev.eli(context, "tt_video_download_apk"));
        wCVar4.setTextColor(-1);
        wCVar4.setTextSize(2, 16.0f);
        wCVar4.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, SSo.DbA(context, 36.0f));
        layoutParams5.setMargins(SSo.DbA(context, 20.0f), SSo.DbA(context, 22.0f), SSo.DbA(context, 20.0f), SSo.DbA(context, 20.0f));
        uiVar2.addView(wCVar4, layoutParams5);
        setDownloadButtonData(wCVar4, evVar, i);
    }

    private void initOneSlotMultipleAdsLayoutForTwoAdVertical(com.bytedance.sdk.openadsdk.core.ui.ui uiVar) {
        if (this.adContext.DbA != null) {
            List<ev> aGH = this.adContext.DbA.Os().aGH();
            for (int i = 0; i < aGH.size() && i < 2; i++) {
                initSingleCardInTwoCardStyle(uiVar, aGH.get(i), i);
            }
        }
    }

    private void initSingleCardInTwoCardStyle(com.bytedance.sdk.openadsdk.core.ui.ui uiVar, ev evVar, int i) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar2.setOrientation(1);
        uiVar2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i > 0 ? SSo.DbA(context, 12.0f) : 0, 0, 0);
        uiVar2.setBackground(new eli(context));
        uiVar.addView(uiVar2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.aGH dVVar = new dV(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(SSo.DbA(context, 70.0f), SSo.DbA(context, 63.0f));
        layoutParams2.setMargins(0, SSo.DbA(context, 24.0f), 0, SSo.DbA(context, 12.0f));
        uiVar2.addView(dVVar, layoutParams2);
        bindIconData(dVVar, evVar);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setSingleLine(true);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setTextSize(18.0f);
        wCVar.setTextColor(Color.parseColor("#161823"));
        wCVar.setGravity(17);
        wCVar.setTypeface(null, 1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(SSo.DbA(context, 56.0f), 0, SSo.DbA(context, 56.0f), 0);
        uiVar2.addView(wCVar, layoutParams3);
        bindTitleData(wCVar, evVar, evVar.kEI());
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar2.setSingleLine(true);
        wCVar2.setEllipsize(TextUtils.TruncateAt.END);
        wCVar2.setTextSize(16.0f);
        wCVar2.setTextColor(Color.parseColor("#80161823"));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(SSo.DbA(context, 56.0f), SSo.DbA(context, 4.0f), SSo.DbA(context, 56.0f), 0);
        uiVar2.addView(wCVar2, layoutParams4);
        bindDescData(wCVar2, evVar);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar3.setOrientation(0);
        uiVar3.setGravity(16);
        uiVar2.addView(uiVar3, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar3.setTextSize(16.0f);
        wCVar3.setTextColor(Color.parseColor("#80161823"));
        uiVar3.addView(wCVar3, new ViewGroup.LayoutParams(-2, -2));
        aqO aqo = new aqO(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = SSo.DbA(context, 8.0f);
        uiVar3.addView(aqo, layoutParams5);
        SSo.eli(wCVar3, aqo, evVar, 18);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar4 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar4.setGravity(17);
        wCVar4.setId(520093707);
        wCVar4.setText(com.bytedance.sdk.component.utils.ev.eli(context, "tt_video_download_apk"));
        wCVar4.setTextColor(-1);
        wCVar4.setTextSize(2, 16.0f);
        wCVar4.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, SSo.DbA(context, 36.0f));
        layoutParams6.setMargins(SSo.DbA(context, 20.0f), SSo.DbA(context, 36.0f), SSo.DbA(context, 20.0f), SSo.DbA(context, 20.0f));
        uiVar2.addView(wCVar4, layoutParams6);
        setDownloadButtonData(wCVar4, evVar, i);
    }

    private void bindDescData(com.bytedance.sdk.openadsdk.core.ui.wC wCVar, ev evVar) {
        if (wCVar == null) {
            return;
        }
        String bU = evVar.bU();
        if (TextUtils.isEmpty(bU)) {
            return;
        }
        wCVar.setText(bU);
    }

    private void setDownloadButtonData(com.bytedance.sdk.openadsdk.core.ui.wC wCVar, ev evVar, int i) {
        com.bytedance.sdk.openadsdk.core.DbA.ui eli2 = this.adContext.KM.eli(this.adContext, evVar);
        eli2.eli(com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this.adContext.SSo, this.adContext.ui));
        if (i != -1) {
            HashMap hashMap = new HashMap();
            int i2 = i + 1;
            hashMap.put("ad_show_order", Integer.valueOf(i2));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_show_order", i2);
                hashMap.put("pag_json_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
            eli2.eli(hashMap);
        }
        wCVar.setOnClickListener(eli2);
        wCVar.setOnTouchListener(eli2);
        CharSequence GMu = evVar.GMu();
        if (TextUtils.isEmpty(GMu)) {
            return;
        }
        wCVar.setText(GMu);
    }

    private void initViewsForVast() {
        Context context = getContext();
        setBackgroundColor(-16777216);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setId(com.bytedance.sdk.openadsdk.utils.aqO.wC);
        agh.setVisibility(8);
        addView(agh, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(context, true);
        mga.setVisibility(8);
        mga.setId(com.bytedance.sdk.openadsdk.utils.aqO.FC);
        addView(mga, new FrameLayout.LayoutParams(-1, -1));
    }

    private void initViewsDefault() {
        FrameLayout.LayoutParams layoutParams;
        Context context = getContext();
        boolean z = this.adContext.DbA.WO() == 1;
        setBackgroundColor(-16777216);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setGravity(1);
        uiVar.setOrientation(1);
        if (z) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(SSo.DbA(context, 327.0f), -2);
        }
        layoutParams.gravity = 17;
        int DbA = SSo.DbA(context, 24.0f);
        layoutParams.rightMargin = DbA;
        layoutParams.leftMargin = DbA;
        addView(uiVar, layoutParams);
        dV dVVar = new dV(context);
        this.ivIcon = dVVar;
        dVVar.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(SSo.DbA(context, 80.0f), SSo.DbA(context, 80.0f));
        layoutParams2.bottomMargin = SSo.DbA(context, 12.0f);
        uiVar.addView(this.ivIcon, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.tvTitle = wCVar;
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        this.tvTitle.setGravity(17);
        this.tvTitle.setMaxLines(2);
        this.tvTitle.setMaxWidth(SSo.DbA(context, 180.0f));
        this.tvTitle.setTextColor(-1);
        this.tvTitle.setTextSize(2, 24.0f);
        uiVar.addView(this.tvTitle, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.tvDesc = wCVar2;
        wCVar2.setEllipsize(TextUtils.TruncateAt.END);
        this.tvDesc.setGravity(17);
        this.tvDesc.setMaxLines(2);
        this.tvDesc.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.tvDesc.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = SSo.DbA(context, 8.0f);
        uiVar.addView(this.tvDesc, layoutParams3);
        this.rbScore = new aqO(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, SSo.DbA(context, 16.0f));
        layoutParams4.topMargin = SSo.DbA(context, 12.0f);
        this.rbScore.setVisibility(8);
        uiVar.addView(this.rbScore, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.tvDownload = wCVar3;
        wCVar3.setId(520093707);
        this.tvDownload.setGravity(17);
        this.tvDownload.setText(com.bytedance.sdk.component.utils.ev.eli(context, "tt_video_download_apk"));
        this.tvDownload.setTextColor(-1);
        this.tvDownload.setTextSize(2, 16.0f);
        this.tvDownload.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, SSo.DbA(context, 44.0f));
        layoutParams5.topMargin = SSo.DbA(context, 54.0f);
        uiVar.addView(this.tvDownload, layoutParams5);
        this.adLogo = PAGLogoView.createPAGLogoViewByMaterial(context, this.adContext.DbA);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, SSo.DbA(context, 14.0f));
        layoutParams6.gravity = 8388691;
        layoutParams6.leftMargin = SSo.DbA(context, 18.0f);
        if (z) {
            layoutParams6.bottomMargin = SSo.DbA(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = SSo.DbA(context, 24.0f);
        }
        addView(this.adLogo, layoutParams6);
    }

    public void setShownAdCount(int i) {
        this.shownAdCount = i;
    }

    private static final class eli extends Drawable {
        private final Drawable DbA;
        private final int Os;
        Path eli = new Path();

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public eli(Context context) {
            this.DbA = com.bytedance.sdk.component.utils.ev.Os(context, "tt_ad_bg_header_gradient");
            this.Os = SSo.DbA(context, 8.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.clipPath(this.eli);
            canvas.drawColor(-1);
            this.DbA.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            float f = i3;
            this.DbA.setBounds(i, i2, i3, (int) (((1.0f * f) / this.DbA.getIntrinsicWidth()) * this.DbA.getIntrinsicHeight()));
            this.eli.reset();
            Path path = this.eli;
            RectF rectF = new RectF(0.0f, 0.0f, f, i4);
            int i5 = this.Os;
            path.addRoundRect(rectF, i5, i5, Path.Direction.CCW);
        }
    }
}
