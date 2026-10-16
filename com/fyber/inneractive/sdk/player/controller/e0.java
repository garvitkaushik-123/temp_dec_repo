package com.fyber.inneractive.sdk.player.controller;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.util.g1;

/* loaded from: classes4.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final v f1362a;
    public final Dialog b;

    public e0(Context context, com.fyber.inneractive.sdk.config.global.features.c cVar, v vVar) {
        this.f1362a = vVar;
        Dialog dialog = new Dialog(context);
        this.b = dialog;
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.ia_layout_skip_rewarded_dialog);
        Button button = (Button) dialog.findViewById(R.id.ia_keep_watching_button);
        Button button2 = (Button) dialog.findViewById(R.id.ia_close_button);
        TextView textView = (TextView) dialog.findViewById(R.id.ia_skip_dialog_title_textview);
        TextView textView2 = (TextView) dialog.findViewById(R.id.ia_skip_dialog_sub_title_textview);
        String string = context.getString(R.string.ia_skip_rewarded_dialog_keep_watching);
        String string2 = context.getString(R.string.ia_skip_rewarded_dialog_close_button);
        String string3 = context.getString(R.string.ia_skip_rewarded_dialog_title);
        String string4 = context.getString(R.string.ia_skip_rewarded_dialog_sub_title);
        if (cVar != null) {
            String a2 = cVar.a("skip_reward_dialog_keep_watching_button", "KEEP WATCHING");
            String trim = a2.trim().length() > 0 ? a2.trim() : "KEEP WATCHING";
            string = TextUtils.isEmpty(trim) ? string : trim;
            String a3 = cVar.a("skip_reward_dialog_close_button", "CLOSE");
            String trim2 = a3.trim().length() > 0 ? a3.trim() : "CLOSE";
            string2 = TextUtils.isEmpty(trim2) ? string2 : trim2;
            String a4 = cVar.a("skip_reward_dialog_title", "Close Video?");
            String trim3 = a4.trim().length() > 0 ? a4.trim() : "Close Video?";
            string3 = TextUtils.isEmpty(trim3) ? string3 : trim3;
            String a5 = cVar.a("skip_reward_dialog_sub_title", "Reward will not be received before video completion.");
            String trim4 = a5.trim().length() > 0 ? a5.trim() : "Reward will not be received before video completion.";
            if (!TextUtils.isEmpty(trim4)) {
                string4 = trim4;
            }
        }
        button.setText(g1.a(string, 13));
        button2.setText(g1.a(string2, 13));
        textView.setText(g1.a(string3, 20));
        textView2.setText(g1.a(string4, 100));
        button2.setOnClickListener(new c0(this));
        button.setOnClickListener(new d0(this));
    }
}
