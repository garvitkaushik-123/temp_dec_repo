package com.mbridge.msdk.foundation.feedback.bean;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.setting.b;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: FeedBackBtnBean.java */
/* loaded from: classes6.dex */
public class a {
    private static int A = -1;
    private static String B;
    private String b;
    private CampaignEx c;
    private FeedBackButton e;
    private String f;
    private String i;
    private MBFeedBackDialog j;
    private Dialog k;
    private JSONArray l;
    private int q;
    private List<g> r;
    private int u;

    /* renamed from: a, reason: collision with root package name */
    private float f4254a = 1.0f;
    private String d = "";
    private float g = -1.0f;
    private int h = -1;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = -1;
    private int s = u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 20.0f);
    private String t = "";
    private com.mbridge.msdk.widget.dialog.b v = new C0334a();
    private int w = A;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    /* compiled from: FeedBackBtnBean.java */
    /* renamed from: com.mbridge.msdk.foundation.feedback.bean.a$a, reason: collision with other inner class name */
    class C0334a implements com.mbridge.msdk.widget.dialog.b {
        C0334a() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            a.this.m();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            a.this.l();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
            a.this.n();
        }
    }

    /* compiled from: FeedBackBtnBean.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.p();
        }
    }

    /* compiled from: FeedBackBtnBean.java */
    class c implements com.mbridge.msdk.widget.dialog.b {
        c() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            a.this.m();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            a.this.l();
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
            a.this.n();
        }
    }

    /* compiled from: FeedBackBtnBean.java */
    class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                String unused = a.B = (String) compoundButton.getText();
            }
            if (a.this.j != null) {
                a.this.j.setCancelButtonClickable(!TextUtils.isEmpty(a.B));
            }
        }
    }

    /* compiled from: FeedBackBtnBean.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.k == null || !a.this.k.isShowing()) {
                    return;
                }
                a.this.k.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: FeedBackBtnBean.java */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.p();
        }
    }

    public a(String str) {
        this.r = new ArrayList();
        this.i = str;
        if (this.r == null) {
            this.r = new ArrayList();
        }
        d();
        e();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 1, 4, B, this.d);
        List<g> list = this.r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.b();
                }
            }
        }
        o();
        B = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 0, 4, B, this.d);
        List<g> list = this.r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.a();
                }
            }
        }
        B = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 0, 4, B, this.d);
        Context f2 = com.mbridge.msdk.foundation.controller.c.m().f();
        if (f2 == null) {
            f2 = com.mbridge.msdk.foundation.controller.c.m().d();
        }
        List<g> list = this.r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.a();
                }
            }
        }
        a(f2);
        B = "";
    }

    private void o() {
        if (TextUtils.isEmpty(this.t)) {
            return;
        }
        try {
            Activity a2 = com.mbridge.msdk.foundation.feedback.b.b().a(com.mbridge.msdk.foundation.controller.c.m().d());
            if (a2 != null) {
                View inflate = LayoutInflater.from(a2).inflate(h0.a(a2, "mbridge_cm_feedback_notice_layout", "layout"), (ViewGroup) null);
                Dialog dialog = new Dialog(a2, 3);
                this.k = dialog;
                dialog.requestWindowFeature(1);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.k.getWindow();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.k.setContentView(inflate);
                this.k.show();
                window.setAttributes(layoutParams);
                inflate.postDelayed(new e(), 2000L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        FeedBackButton feedBackButton = this.e;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.e.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.e.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.e);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.j;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.j.setListener(null);
        }
        this.j = null;
        this.r = null;
        this.e = null;
        this.v = null;
    }

    public void g() {
        MBFeedBackDialog mBFeedBackDialog = this.j;
        if (mBFeedBackDialog == null || !mBFeedBackDialog.isShowing()) {
            return;
        }
        this.j.cancel();
    }

    public CampaignEx h() {
        return this.c;
    }

    public FeedBackButton i() {
        if (this.e == null) {
            e();
        }
        return this.e;
    }

    public int j() {
        return this.q;
    }

    public int k() {
        return this.u;
    }

    public void p() {
        try {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 0, 1, B, this.d);
            Activity a2 = com.mbridge.msdk.foundation.feedback.b.b().a(com.mbridge.msdk.foundation.controller.c.m().d());
            MBFeedBackDialog mBFeedBackDialog = this.j;
            if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != a2) {
                c();
            }
            Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
            FeedBackButton feedBackButton = this.e;
            if (feedBackButton != null) {
                d2 = feedBackButton.getContext();
            }
            boolean a3 = com.mbridge.msdk.foundation.feedback.b.b().a(this.i, d2, this.j);
            a(a3 ? 2 : 3);
            if (a3) {
                return;
            }
            a(d2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        try {
            if (com.mbridge.msdk.foundation.feedback.b.b().a(com.mbridge.msdk.foundation.controller.c.m().d()) != null) {
                com.mbridge.msdk.setting.g d2 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d2 == null) {
                    d2 = h.b().a();
                }
                b.C0384b z = d2.z();
                if (z == null) {
                    p0.c("", "feedback fbk is null");
                    return;
                }
                d();
                this.j = new MBFeedBackDialog(com.mbridge.msdk.foundation.feedback.b.b().a(com.mbridge.msdk.foundation.controller.c.m().d()), this.v);
                FeedbackRadioGroup a2 = a(z);
                this.j.setCancelText(z.d());
                this.j.setConfirmText(z.a());
                this.j.setPrivacyText(z.c());
                this.t = z.e();
                this.j.setTitle(z.f());
                this.j.setContent(a2);
                this.j.setCancelButtonClickable(!TextUtils.isEmpty(B));
                a(a2, z);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        if (this.v == null) {
            this.v = new c();
        }
    }

    private void e() {
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d2 != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(d2);
                this.e = feedBackButton;
                int i = 8;
                if (this.w != 8) {
                    i = 0;
                }
                feedBackButton.setVisibility(i);
                this.e.setOnClickListener(new b());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(String str) {
        this.d = str;
    }

    /* compiled from: FeedBackBtnBean.java */
    public static class g implements com.mbridge.msdk.widget.dialog.b {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.foundation.feedback.a f4261a;
        private String b;

        public g(String str, com.mbridge.msdk.foundation.feedback.a aVar) {
            this.f4261a = aVar;
            this.b = str;
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            com.mbridge.msdk.foundation.feedback.b.f = false;
            com.mbridge.msdk.foundation.feedback.a aVar = this.f4261a;
            if (aVar != null) {
                aVar.close();
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            com.mbridge.msdk.foundation.feedback.b.f = false;
            com.mbridge.msdk.foundation.feedback.a aVar = this.f4261a;
            if (aVar != null) {
                aVar.a(a.B);
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
            com.mbridge.msdk.foundation.feedback.a aVar = this.f4261a;
            if (aVar != null) {
                aVar.close();
            }
        }

        public void a(int i) {
            if (this.f4261a == null || i != 2) {
                return;
            }
            com.mbridge.msdk.foundation.feedback.b.f = true;
            this.f4261a.a();
        }
    }

    private void b() {
        FeedBackButton feedBackButton = this.e;
        if (feedBackButton != null) {
            int i = this.y;
            if (i > -1) {
                feedBackButton.setX(i);
            }
            int i2 = this.z;
            if (i2 > -1) {
                this.e.setY(i2);
            }
            float f2 = this.f4254a;
            if (f2 >= 0.0f) {
                this.e.setAlpha(f2);
                this.e.setEnabled(this.f4254a != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            int i3 = this.x;
            if (i3 > 0) {
                this.e.setWidth(i3);
                if (layoutParams != null) {
                    layoutParams.width = this.x;
                }
            }
            int i4 = this.h;
            if (i4 > 0) {
                this.e.setHeight(i4);
                if (layoutParams != null) {
                    layoutParams.height = this.h;
                }
            }
            if (layoutParams != null) {
                this.e.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.f)) {
                    this.e.setTextColor(Color.parseColor(this.f));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            float f3 = this.g;
            if (f3 > 0.0f) {
                this.e.setTextSize(f3);
            }
            JSONArray jSONArray = this.l;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
                this.e.setPadding(u0.a(d2, (float) this.l.optDouble(0)), u0.a(d2, (float) this.l.optDouble(1)), u0.a(d2, (float) this.l.optDouble(2)), u0.a(d2, (float) this.l.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i5 = this.s;
            if (i5 > 0) {
                gradientDrawable.setCornerRadius(i5);
            }
            if (!TextUtils.isEmpty(this.b)) {
                gradientDrawable.setColor(Color.parseColor(this.b));
            } else {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            }
            this.e.setBackground(gradientDrawable);
        }
    }

    public void a(g gVar) {
        if (this.r == null) {
            this.r = new ArrayList();
        }
        this.r.add(gVar);
    }

    public void d(int i) {
        this.w = i;
        FeedBackButton feedBackButton = this.e;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i);
        }
    }

    public void a(CampaignEx campaignEx) {
        this.c = campaignEx;
    }

    private void a(int i) {
        if (i == 2) {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 0, 2, B, this.d);
        } else {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.i, 0, 3, B, this.d);
        }
        List<g> list = this.r;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.a(i);
                }
            }
        }
    }

    private void a(Context context) {
        if (context != null) {
            try {
                com.mbridge.msdk.click.c.e(context, u0.a(this.c));
            } catch (Exception unused) {
                com.mbridge.msdk.click.c.c(context, u0.a(this.c));
            }
        }
    }

    private FeedbackRadioGroup a(b.C0384b c0384b) {
        JSONArray b2 = c0384b.b();
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (b2 == null || b2.length() <= 0 || d2 == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(d2);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(FeedbackRadioGroup feedbackRadioGroup, b.C0384b c0384b) {
        ColorStateList colorStateList;
        int i;
        JSONArray b2 = c0384b.b();
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (b2 == null || b2.length() <= 0 || d2 == null) {
            return;
        }
        h0.a(d2, "mbridge_cm_feedback_choice_btn_bg", "drawable");
        Resources a2 = h0.a(d2);
        int a3 = h0.a(d2, "mbridge_cm_feedback_rb_text_color_color_list", "color");
        if (a2 != null) {
            try {
                colorStateList = a2.getColorStateList(a3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int a4 = u0.a(d2, 1.0f);
            int a5 = u0.a(d2, 1.0f);
            int a6 = u0.a(d2, 1.0f);
            for (i = 0; i < b2.length(); i++) {
                String optString = b2.optString(i);
                RadioButton radioButton = new RadioButton(d2);
                radioButton.setButtonTintList(colorStateList);
                radioButton.setText(optString);
                if (colorStateList != null) {
                    radioButton.setTextColor(colorStateList);
                }
                radioButton.setCompoundDrawablePadding(a4);
                radioButton.setPadding(a4, a5, a4, a5);
                radioButton.setEllipsize(TextUtils.TruncateAt.END);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
                int i2 = a6 / 4;
                layoutParams.setMargins(a6, i2, a6, i2);
                a(radioButton);
                feedbackRadioGroup.addView(radioButton, layoutParams);
            }
        }
        colorStateList = null;
        int a42 = u0.a(d2, 1.0f);
        int a52 = u0.a(d2, 1.0f);
        int a62 = u0.a(d2, 1.0f);
        while (i < b2.length()) {
        }
    }

    public void c(int i) {
        this.u = i;
    }

    public void b(int i) {
        this.q = i;
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new d());
        }
    }

    public void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.e;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f4254a);
            feedBackButton.setEnabled(this.f4254a != 0.0f);
            feedBackButton.setVisibility(this.w != 8 ? 0 : 8);
            this.e = feedBackButton;
            CampaignEx campaignEx = this.c;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                b();
            }
            feedBackButton.setOnClickListener(new f());
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, float f2, String str, String str2, float f3, JSONArray jSONArray) {
        if (i > -1) {
            this.y = i;
        }
        if (i2 > -1) {
            this.z = i2;
        }
        if (i3 > -1) {
            this.x = i3;
        }
        if (i4 > -1) {
            this.h = i4;
        }
        if (f3 > -1.0f) {
            this.g = f3;
        }
        if (jSONArray != null) {
            this.l = jSONArray;
        }
        this.f = str;
        this.b = str2;
        this.f4254a = f2;
        this.s = i5;
        b();
    }
}
