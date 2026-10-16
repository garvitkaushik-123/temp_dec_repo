package com.applovin.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.impl.d;
import com.applovin.impl.l3;
import com.applovin.impl.p2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.mediation.MaxDebuggerUnifiedFlowActivity;

/* loaded from: classes2.dex */
public abstract class j3 extends k3 {

    /* renamed from: a, reason: collision with root package name */
    private l3 f491a;
    private DataSetObserver b;
    private FrameLayout c;
    private ListView d;
    private com.applovin.impl.a e;

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            j3.this.a();
            j3 j3Var = j3.this;
            j3Var.b((Context) j3Var);
        }
    }

    class b implements p2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.c f493a;

        class a implements d.b {
            a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerUnifiedFlowActivity maxDebuggerUnifiedFlowActivity) {
                maxDebuggerUnifiedFlowActivity.initialize(j3.this.f491a.t());
            }
        }

        /* renamed from: com.applovin.impl.j3$b$b, reason: collision with other inner class name */
        class C0095b implements d.b {
            C0095b() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                maxDebuggerTcfInfoListActivity.initialize(j3.this.f491a.d(), j3.this.f491a.t());
            }
        }

        class c implements d.b {
            c() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                maxDebuggerTcfConsentStatusesListActivity.initialize(j3.this.f491a.d(), j3.this.f491a.t());
            }
        }

        class d implements d.b {
            d() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(j3.this.f491a.f(), false, j3.this.f491a.t());
            }
        }

        class e implements d.b {
            e() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                maxDebuggerTestLiveNetworkActivity.initialize(j3.this.f491a.k(), j3.this.f491a.w(), j3.this.f491a.t());
            }
        }

        class f implements d.b {
            f() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                maxDebuggerTestModeNetworkActivity.initialize(j3.this.f491a.v(), j3.this.f491a.t());
            }
        }

        class g implements d.b {
            g() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(j3.this.f491a.o(), true, j3.this.f491a.t());
            }
        }

        class h implements d.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ o2 f501a;

            h(o2 o2Var) {
                this.f501a = o2Var;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                maxDebuggerDetailActivity.initialize(((w3) this.f501a).r());
            }
        }

        b(com.applovin.impl.c cVar) {
            this.f493a = cVar;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            int b = i2Var.b();
            if (b == l3.e.APP_INFO.ordinal()) {
                k7.a(o2Var.c(), o2Var.b(), j3.this);
                return;
            }
            if (b == l3.e.MAX.ordinal()) {
                if (j3.this.f491a.a(o2Var)) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerUnifiedFlowActivity.class, this.f493a, new a());
                    return;
                } else {
                    k7.a(o2Var.c(), o2Var.b(), j3.this);
                    return;
                }
            }
            if (b == l3.e.PRIVACY.ordinal()) {
                if (i2Var.a() != l3.d.CMP.ordinal()) {
                    if (i2Var.a() == l3.d.NETWORK_CONSENT_STATUSES.ordinal()) {
                        com.applovin.impl.d.a(j3.this, MaxDebuggerTcfConsentStatusesListActivity.class, this.f493a, new c());
                        return;
                    }
                    return;
                } else if (StringUtils.isValidString(j3.this.f491a.t().s0().j())) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerTcfInfoListActivity.class, this.f493a, new C0095b());
                    return;
                } else {
                    k7.a(o2Var.c(), o2Var.b(), j3.this);
                    return;
                }
            }
            if (b != l3.e.ADS.ordinal()) {
                if ((b == l3.e.MICRO_SDK_PARTNER_NETWORKS.ordinal() || b == l3.e.INCOMPLETE_NETWORKS.ordinal() || b == l3.e.COMPLETED_NETWORKS.ordinal()) && (o2Var instanceof w3)) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerDetailActivity.class, this.f493a, new h(o2Var));
                    return;
                }
                return;
            }
            if (i2Var.a() == l3.b.AD_UNITS.ordinal()) {
                if (j3.this.f491a.f().size() > 0) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerAdUnitsListActivity.class, this.f493a, new d());
                    return;
                } else {
                    k7.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", j3.this);
                    return;
                }
            }
            if (i2Var.a() == l3.b.SELECT_LIVE_NETWORKS.ordinal()) {
                if (j3.this.f491a.k().size() <= 0 && j3.this.f491a.w().size() <= 0) {
                    k7.a("Complete Integrations", "Please complete integrations in order to access this.", j3.this);
                    return;
                } else if (j3.this.f491a.t().t0().c()) {
                    k7.a("Restart Required", o2Var.b(), j3.this);
                    return;
                } else {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerTestLiveNetworkActivity.class, this.f493a, new e());
                    return;
                }
            }
            if (i2Var.a() != l3.b.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                if (i2Var.a() == l3.b.INITIALIZATION_AD_UNITS.ordinal()) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerAdUnitsListActivity.class, this.f493a, new g());
                }
            } else if (!j3.this.f491a.t().t0().c()) {
                j3.this.getSdk().t0().a();
                k7.a("Restart Required", o2Var.b(), j3.this);
            } else if (j3.this.f491a.v().size() > 0) {
                com.applovin.impl.d.a(j3.this, MaxDebuggerTestModeNetworkActivity.class, this.f493a, new f());
            } else {
                k7.a("Complete Integrations", "Please complete integrations in order to access this.", j3.this);
            }
        }
    }

    private void c() {
        a();
        com.applovin.impl.a aVar = new com.applovin.impl.a(this, 50, R.attr.progressBarStyleLarge);
        this.e = aVar;
        aVar.setColor(-3355444);
        this.c.addView(this.e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.c.bringChildToFront(this.e);
        this.e.a();
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        l3 l3Var = this.f491a;
        if (l3Var != null) {
            return l3Var.t();
        }
        return null;
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(com.applovin.sdk.R.layout.mediation_debugger_list_view);
        this.c = (FrameLayout) findViewById(R.id.content);
        ListView listView = (ListView) findViewById(com.applovin.sdk.R.id.listView);
        this.d = listView;
        listView.setAdapter((ListAdapter) this.f491a);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.applovin.sdk.R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        l3 l3Var = this.f491a;
        if (l3Var != null) {
            l3Var.unregisterDataSetObserver(this.b);
            this.f491a.a((p2.a) null);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.applovin.sdk.R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        b();
        return true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        l3 l3Var = this.f491a;
        if (l3Var == null || l3Var.y()) {
            return;
        }
        c();
    }

    public void setListAdapter(l3 l3Var, c cVar) {
        DataSetObserver dataSetObserver;
        l3 l3Var2 = this.f491a;
        if (l3Var2 != null && (dataSetObserver = this.b) != null) {
            l3Var2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f491a = l3Var;
        this.b = new a();
        b((Context) this);
        this.f491a.registerDataSetObserver(this.b);
        this.f491a.a(new b(cVar));
    }

    private void b() {
        l3 l3Var = this.f491a;
        if (l3Var == null) {
            return;
        }
        String p = l3Var.p();
        if (TextUtils.isEmpty(p)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", p);
        intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
        intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
        startActivity(Intent.createChooser(intent, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.applovin.impl.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
            this.c.removeView(this.e);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        k7.a(this.f491a.i(), this.f491a.h(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context) {
        if (!StringUtils.isValidString(this.f491a.h()) || this.f491a.x()) {
            return;
        }
        this.f491a.b(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.j3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                j3.this.a(context);
            }
        });
    }
}
