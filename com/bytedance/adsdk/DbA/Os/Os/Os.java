package com.bytedance.adsdk.DbA.Os.Os;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.DbA.Xb;
import com.bytedance.adsdk.DbA.aAs;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Os extends aGH {
    private final LinearLayout.LayoutParams FC;
    private final List<String> aAs;
    private final List<TextView> du;
    private String nlS;
    private LinearLayout wC;

    public Os(com.bytedance.adsdk.DbA.FC fc, ui uiVar, Context context) {
        super(fc, uiVar);
        List<aAs.eli> Os;
        this.FC = new LinearLayout.LayoutParams(-2, -2);
        this.aAs = new ArrayList();
        this.du = new ArrayList();
        if (this.kb == null || (Os = this.kb.Os()) == null || Os.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.wC = linearLayout;
        int i = 0;
        linearLayout.setOrientation(0);
        DbA(Os.get(0).kb);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.wC.addView(linearLayout2);
        List<String> nlS = nlS();
        while (i < Os.size()) {
            aAs.eli eliVar = Os.get(i);
            TextView textView = new TextView(context);
            eli(textView, eliVar, (nlS == null || i >= nlS.size()) ? "" : nlS.get(i));
            if (eliVar.MGA != 0) {
                this.FC.bottomMargin = (int) (eliVar.MGA * com.bytedance.adsdk.DbA.MGA.MGA.eli());
                linearLayout2.addView(textView, this.FC);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float eli = com.bytedance.adsdk.DbA.MGA.MGA.eli();
        eli(this.wC, (int) (this.kb.eli() * eli), (int) (this.kb.DbA() * eli));
    }

    private void DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            this.wC.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals("left")) {
            this.wC.setGravity(3);
        } else if (str.equals("right")) {
            this.wC.setGravity(5);
        } else {
            this.wC.setGravity(17);
        }
    }

    private void eli(TextView textView, aAs.eli eliVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        if (!TextUtils.isEmpty(eliVar.Os)) {
            textView.setTextColor(Color.parseColor(eliVar.Os));
        }
        if (!TextUtils.isEmpty(eliVar.aGH)) {
            textView.setBackgroundColor(Color.parseColor(eliVar.aGH));
        }
        textView.setGravity(17);
        textView.setTextSize(eliVar.ui);
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.aGH, com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        if (this.wC != null) {
            canvas.save();
            canvas.concat(matrix);
            eli(i);
            Os(MGA());
            this.wC.draw(canvas);
            canvas.restore();
            return;
        }
        super.DbA(canvas, matrix, i);
    }

    private void Os(float f) {
        List<aAs.eli> Os;
        if (this.kb == null || (Os = this.kb.Os()) == null || Os.size() <= 0) {
            return;
        }
        this.wC.setOrientation(0);
        this.wC.setGravity(17);
        if (this.wC.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.wC.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.wC.removeAllViews();
        if (linearLayout.getChildCount() != Os.size()) {
            return;
        }
        List<String> nlS = nlS();
        this.du.clear();
        int i = 0;
        while (i < Os.size()) {
            aAs.eli eliVar = Os.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.du.add(textView);
            eli(textView, eliVar, (nlS == null || i >= nlS.size()) ? "" : nlS.get(i));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < Os.size(); i2++) {
            aAs.eli eliVar2 = Os.get(i2);
            TextView textView2 = this.du.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            if (eliVar2.MGA != 0) {
                this.FC.bottomMargin = (int) (eliVar2.MGA * com.bytedance.adsdk.DbA.MGA.MGA.eli());
                linearLayout.addView(textView2, this.FC);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.wC.setAlpha(f);
        this.wC.addView(linearLayout);
        float eli = com.bytedance.adsdk.DbA.MGA.MGA.eli();
        eli(this.wC, (int) (this.kb.eli() * eli), (int) (this.kb.DbA() * eli));
    }

    private List<String> nlS() {
        Xb Vy;
        List<aAs.eli> Os;
        if (this.kb == null || this.DbA == null || (Vy = this.DbA.Vy()) == null) {
            return null;
        }
        String aGH = this.kb.aGH();
        if ((!TextUtils.isEmpty(aGH) || !TextUtils.isEmpty(this.nlS)) && (Os = this.kb.Os()) != null) {
            String str = this.nlS;
            if (TextUtils.isEmpty(str)) {
                str = Vy.eli(aGH);
            }
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                this.aAs.clear();
                for (int i = 0; i < Os.size(); i++) {
                    aAs.eli eliVar = Os.get(i);
                    int i2 = eliVar.eli;
                    int i3 = eliVar.DbA;
                    if (i2 < 0) {
                        i2 = Math.max(i2 + length, 0);
                    }
                    if (i3 < 0) {
                        i3 = Math.max(i3 + length, 0);
                    }
                    if (i2 + i3 > length) {
                        this.aAs.add("");
                    } else {
                        if (Os.size() == 1 && i2 == 0 && i3 == 0) {
                            i3 = length;
                        }
                        this.aAs.add(str.substring(i2, i3 + i2));
                    }
                }
                return this.aAs;
            }
        }
        return null;
    }

    private static void eli(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void eli(String str) {
        this.nlS = str;
    }
}
