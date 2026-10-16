package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.applovin.sdk.R;

/* loaded from: classes2.dex */
public abstract class n1 extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private p1 f596a;
    private com.applovin.impl.sdk.k b;
    private TextView c;
    private Button d;

    private void b() {
        s2 s2Var = new s2();
        s2Var.a(this.b.z().a(this.f596a));
        String b = this.b.z().b(this.f596a.a());
        if (b != null) {
            s2Var.a("\nBid Response Preview:\n");
            s2Var.a(b);
        }
        TextView textView = (TextView) findViewById(R.id.email_report_tv);
        this.c = textView;
        textView.setText(s2Var.toString());
        this.c.setTextColor(-16777216);
    }

    public void a(p1 p1Var, com.applovin.impl.sdk.k kVar) {
        this.f596a = p1Var;
        this.b = kVar;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a()) {
            finish();
            return;
        }
        setTitle(this.f596a.c() + " - " + this.f596a.d());
        setContentView(R.layout.creative_debugger_displayed_ad_detail_activity);
        b();
        b8.a(findViewById(android.R.id.content), this.b);
        Button button = (Button) findViewById(R.id.report_ad_button);
        this.d = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.n1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n1.this.a(view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.creative_debugger_displayed_ad_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!a()) {
            finish();
            return false;
        }
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.b.z().a(this.f596a, (Context) this, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.b.z().a(this.f596a, (Context) this, true);
    }

    private boolean a() {
        return (this.f596a == null || this.b == null) ? false : true;
    }
}
