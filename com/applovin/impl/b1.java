package com.applovin.impl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.c1;
import com.applovin.impl.d;
import com.applovin.impl.p2;
import com.applovin.sdk.R;

/* loaded from: classes2.dex */
public abstract class b1 extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private c1 f394a;
    private FrameLayout b;
    private ListView c;

    class a implements p2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f395a;

        /* renamed from: com.applovin.impl.b1$a$a, reason: collision with other inner class name */
        class C0091a implements d.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i2 f396a;

            C0091a(i2 i2Var) {
                this.f396a = i2Var;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
                maxCreativeDebuggerDisplayedAdActivity.a((p1) b1.this.f394a.d().get(this.f396a.a()), b1.this.f394a.e());
            }
        }

        a(c cVar) {
            this.f395a = cVar;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            if (i2Var.b() != c1.a.RECENT_ADS.ordinal()) {
                return;
            }
            d.a(b1.this, MaxCreativeDebuggerDisplayedAdActivity.class, this.f395a, new C0091a(i2Var));
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Creative Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.b = (FrameLayout) findViewById(android.R.id.content);
        this.c = (ListView) findViewById(R.id.listView);
        b8.a(this.b, com.applovin.impl.sdk.k.D0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c1 c1Var = this.f394a;
        if (c1Var != null) {
            c1Var.a((p2.a) null);
            this.f394a.g();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        c1 c1Var = this.f394a;
        if (c1Var == null) {
            finish();
            return;
        }
        this.c.setAdapter((ListAdapter) c1Var);
        c1 c1Var2 = this.f394a;
        if (c1Var2 != null && !c1Var2.e().z().g()) {
            a(R.string.applovin_creative_debugger_disabled_text);
            return;
        }
        c1 c1Var3 = this.f394a;
        if (c1Var3 == null || !c1Var3.f()) {
            return;
        }
        a(R.string.applovin_creative_debugger_no_ads_text);
    }

    public void a(c1 c1Var, c cVar) {
        this.f394a = c1Var;
        c1Var.a(new a(cVar));
    }

    private void a(int i) {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setText(i);
        this.b.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.b.bringChildToFront(textView);
    }
}
