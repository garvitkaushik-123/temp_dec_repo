package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.e1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.x0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.Locale;

/* loaded from: classes6.dex */
public class MBAlertDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Button f5298a;
    private Button b;
    private TextView c;
    private com.mbridge.msdk.widget.dialog.b d;
    private TextView e;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.widget.dialog.b f5299a;

        a(com.mbridge.msdk.widget.dialog.b bVar) {
            this.f5299a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.widget.dialog.b bVar = this.f5299a;
            if (bVar != null) {
                bVar.b();
            }
            MBAlertDialog.this.cancel();
            MBAlertDialog.this.clear();
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.widget.dialog.b f5300a;

        b(com.mbridge.msdk.widget.dialog.b bVar) {
            this.f5300a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.widget.dialog.b bVar = this.f5300a;
            if (bVar != null) {
                bVar.a();
            }
            MBAlertDialog.this.cancel();
            MBAlertDialog.this.clear();
        }
    }

    public MBAlertDialog(Context context, com.mbridge.msdk.widget.dialog.b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(h0.a(context, "mbridge_cm_alertview", "layout"), (ViewGroup) null);
        this.d = bVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.e = (TextView) inflate.findViewById(h0.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e) {
                p0.a("MBAlertDialog", e.getMessage());
            }
            try {
                this.c = (TextView) inflate.findViewById(h0.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.b = (Button) inflate.findViewById(h0.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f5298a = (Button) inflate.findViewById(h0.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e2) {
                p0.a("MBAlertDialog", e2.getMessage());
            }
        }
        Button button = this.f5298a;
        if (button != null) {
            button.setOnClickListener(new a(bVar));
        }
        Button button2 = this.b;
        if (button2 != null) {
            button2.setOnClickListener(new b(bVar));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a(int i) {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle(i == com.mbridge.msdk.foundation.same.a.H ? "Confirm" : "Tips");
            setContent(i == com.mbridge.msdk.foundation.same.a.H ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
            setConfirmText(i == com.mbridge.msdk.foundation.same.a.H ? "Close" : "Cancel");
            setCancelText("Continue");
            return;
        }
        setTitle(i == com.mbridge.msdk.foundation.same.a.H ? "确认关闭？" : "提示");
        setContent(i == com.mbridge.msdk.foundation.same.a.H ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
        setConfirmText(i == com.mbridge.msdk.foundation.same.a.H ? "确认关闭" : "取消");
        setCancelText("继续");
    }

    private void b() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle("Confirm to close? ");
            setContent("You will not be rewarded after closing the window");
            setConfirmText("Close it");
            setCancelText("Continue");
            return;
        }
        setTitle("确认关闭？");
        setContent("关闭后您将不会获得任何奖励噢~ ");
        setConfirmText("确认关闭");
        setCancelText("继续观看");
    }

    public void clear() {
        if (this.d != null) {
            this.d = null;
        }
    }

    public com.mbridge.msdk.widget.dialog.b getListener() {
        return this.d;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(4098);
            e1.a(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void makeDownloadAlert(String str) {
        com.mbridge.msdk.widget.dialog.a.a(this, str);
    }

    public void makeIVAlertView(int i, String str) {
        try {
            String obj = x0.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String obj2 = x0.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String obj3 = x0.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String obj4 = x0.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                a(i);
            } else {
                a(obj, obj2, obj3, obj4);
            }
        } catch (Exception e) {
            p0.a("MBAlertDialog", e.getMessage());
        }
    }

    public void makeInsAlert(String str) {
        com.mbridge.msdk.widget.dialog.a.b(this, str);
    }

    public void makePlayableAlertView() {
        g d = h.b().d(c.m().b());
        if (d != null) {
            a(d.s(), d.q(), d.r(), d.o());
        } else {
            a();
        }
    }

    public void makeRVAlertView(String str) {
        try {
            String obj = x0.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String obj2 = x0.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String obj3 = x0.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String obj4 = x0.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            g d = h.b().d(c.m().b());
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                if (d != null) {
                    a(d.s(), d.q(), d.r(), d.p());
                    return;
                } else {
                    b();
                    return;
                }
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(obj)) {
                if (d != null) {
                    obj = d.s();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setTitle("Confirm to close? ");
                } else {
                    setTitle("确认关闭？");
                }
            }
            if (TextUtils.isEmpty(obj2)) {
                if (d != null) {
                    obj2 = d.q();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setContent("You will not be rewarded after closing the window");
                } else {
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                }
            }
            if (TextUtils.isEmpty(obj4)) {
                if (d != null) {
                    obj4 = d.r();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setConfirmText("Close it");
                } else {
                    setConfirmText("确认关闭");
                }
            }
            if (TextUtils.isEmpty(obj3)) {
                if (d != null) {
                    obj3 = d.p();
                } else if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setCancelText("Continue");
                } else {
                    setCancelText("继续观看");
                }
            }
            a(obj, obj2, obj4, obj3);
        } catch (Exception e) {
            p0.a("MBAlertDialog", e.getMessage());
        }
    }

    public void onlyShow() {
        super.show();
    }

    public void setCancelText(String str) {
        Button button = this.f5298a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.b;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e) {
            p0.b("MBAlertDialog", e.getMessage());
            super.show();
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    private void a() {
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            setTitle("确认关闭？");
            setContent("关闭后您将不会获得任何奖励噢~ ");
            setConfirmText("确认关闭");
            setCancelText("继续试玩");
            return;
        }
        setTitle("Confirm to close? ");
        setContent("You will not be rewarded after closing the window");
        setConfirmText("Close it");
        setCancelText("Continue");
    }
}
