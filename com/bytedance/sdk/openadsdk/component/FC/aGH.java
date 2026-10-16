package com.bytedance.sdk.openadsdk.component.FC;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aqO;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.du;

/* loaded from: classes3.dex */
public class aGH extends Os {
    private final com.bytedance.sdk.openadsdk.core.ui.wC Dfc;
    private final com.bytedance.sdk.openadsdk.core.ui.Os NU;
    private final com.bytedance.sdk.openadsdk.core.ui.aGH aqO;
    private final com.bytedance.sdk.openadsdk.core.ui.ui dV;
    private final aqO nn;

    public aGH(Context context, ev evVar) {
        super(context);
        setId(520093753);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        int DbA = SSo.DbA(context, 8.0f);
        int DbA2 = SSo.DbA(context, 9.0f);
        int DbA3 = SSo.DbA(context, 10.0f);
        int DbA4 = SSo.DbA(context, 40.0f);
        this.nlS = new com.bytedance.sdk.openadsdk.core.widget.Os(context);
        this.nlS.setPadding(DbA2, 0, DbA2, 0);
        this.nlS.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SSo.DbA(context, 32.0f), SSo.DbA(context, 14.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, DbA3, DbA3);
        this.nlS.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        this.NU = os;
        os.setBackgroundColor(-1);
        os.setId(520093758);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, SSo.DbA(context, 107.0f));
        layoutParams2.addRule(12);
        os.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(0);
        uiVar.setGravity(16);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        uiVar.setLayoutParams(layoutParams3);
        os.addView(uiVar);
        this.MGA = new dV(context);
        this.MGA.setId(520093759);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(DbA4, DbA4);
        layoutParams4.rightMargin = DbA;
        layoutParams4.setMarginEnd(DbA);
        this.MGA.setLayoutParams(layoutParams4);
        this.kb = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.kb.setId(520093761);
        this.kb.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.kb.setEllipsize(TextUtils.TruncateAt.END);
        this.kb.setMaxLines(2);
        this.kb.setTextColor(Color.parseColor("#161823"));
        this.kb.setTextSize(30.0f);
        uiVar.addView(this.MGA);
        uiVar.addView(this.kb);
        com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(2, os.getId());
        layoutParams5.addRule(10);
        os2.setLayoutParams(layoutParams5);
        this.eli = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        this.eli.setId(520093754);
        this.eli.setScaleType(ImageView.ScaleType.CENTER_CROP);
        os2.addView(this.eli, new FrameLayout.LayoutParams(-1, -1));
        this.DbA = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        this.DbA.setId(520093755);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 17;
        os2.addView(this.DbA, layoutParams6);
        this.Os = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        this.Os.setId(520093756);
        os2.addView(this.Os, new FrameLayout.LayoutParams(-1, -1));
        this.ui = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.ui.setId(520093717);
        this.ui.setBackground(du.eli(context, Color.parseColor("#b3000000"), 24));
        this.ui.setEllipsize(TextUtils.TruncateAt.END);
        this.ui.setGravity(17);
        this.ui.setSingleLine(true);
        this.ui.setText(com.bytedance.sdk.component.utils.ev.eli(context, "tt_video_download_apk"));
        this.ui.setTextColor(-1);
        this.ui.setTextSize(1, 16.0f);
        this.ui.setTag("open_ad_click_button_tag");
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(SSo.DbA(context, 236.0f), SSo.DbA(context, 48.0f));
        layoutParams7.gravity = 81;
        layoutParams7.bottomMargin = SSo.DbA(context, 32.0f);
        os2.addView(this.ui, layoutParams7);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        this.dV = uiVar2;
        uiVar2.setOrientation(0);
        uiVar2.setGravity(16);
        uiVar2.setBackground(new eli(context));
        uiVar2.setPadding(SSo.DbA(context, 16.0f), SSo.DbA(context, 8.0f), SSo.DbA(context, 16.0f), SSo.DbA(context, 8.0f));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(10);
        layoutParams8.topMargin = SSo.DbA(context, 90.0f);
        uiVar2.setLayoutParams(layoutParams8);
        dV dVVar = new dV(context);
        this.aqO = dVVar;
        uiVar2.addView(dVVar, new LinearLayout.LayoutParams(SSo.DbA(context, 36.0f), SSo.DbA(context, 36.0f)));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.leftMargin = SSo.DbA(context, 8.0f);
        uiVar2.addView(uiVar3, layoutParams9);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.Dfc = wCVar;
        wCVar.setTextColor(-1);
        uiVar3.addView(wCVar, new LinearLayout.LayoutParams(-2, -2));
        aqO aqo = new aqO(context, true);
        this.nn = aqo;
        uiVar3.addView(aqo, new LinearLayout.LayoutParams(-2, -2));
        this.aGH = PAGLogoView.createPAGLogoViewByMaterial(context, evVar);
        this.aGH.setId(520093757);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, SSo.DbA(context, 14.0f));
        layoutParams10.gravity = 83;
        os2.addView(this.aGH, layoutParams10);
        addView(os2);
        addView(this.nlS);
        addView(os);
        addView(this.wC);
        addView(uiVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public View getUserInfo() {
        return this.NU;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public com.bytedance.sdk.openadsdk.core.ui.wC getAdTitleTextView() {
        return this.Dfc;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public com.bytedance.sdk.openadsdk.core.ui.aGH getAdIconView() {
        return this.aqO;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public aqO getScoreBar() {
        return this.nn;
    }

    private static final class eli extends Drawable {
        private final boolean aGH;
        private static final int ui = Color.parseColor("#b0000000");
        private static final int MGA = Color.parseColor("#40000000");
        private final RectF eli = new RectF();
        private final Paint DbA = new Paint();
        private final Path Os = new Path();

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
            this.aGH = com.bytedance.sdk.component.adexpress.aGH.DbA.eli(context);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            float[] fArr;
            super.onBoundsChange(rect);
            this.eli.set(rect);
            this.Os.reset();
            int height = rect.height() / 2;
            Path path = this.Os;
            RectF rectF = this.eli;
            if (this.aGH) {
                float f = height;
                fArr = new float[]{f, f, 0.0f, 0.0f, 0.0f, 0.0f, f, f};
            } else {
                float f2 = height;
                fArr = new float[]{0.0f, 0.0f, f2, f2, f2, f2, 0.0f, 0.0f};
            }
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            float f3 = rect.right;
            boolean z = this.aGH;
            this.DbA.setShader(new LinearGradient(0.0f, 0.0f, f3, 0.0f, new int[]{z ? MGA : ui, z ? ui : MGA}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawPath(this.Os, this.DbA);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public com.bytedance.sdk.openadsdk.core.ui.ui getOverlayLayout() {
        return this.dV;
    }
}
