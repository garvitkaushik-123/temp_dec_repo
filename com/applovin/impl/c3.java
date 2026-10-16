package com.applovin.impl;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.b3;
import com.applovin.impl.d;
import com.applovin.impl.d3;
import com.applovin.impl.p2;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

/* loaded from: classes2.dex */
public abstract class c3 extends k3 {

    /* renamed from: a, reason: collision with root package name */
    private d3 f417a;
    private ListView b;

    class a implements p2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b3 f418a;

        /* renamed from: com.applovin.impl.c3$a$a, reason: collision with other inner class name */
        class C0092a implements d.b {
            C0092a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                maxDebuggerMultiAdActivity.initialize(a.this.f418a);
            }
        }

        a(b3 b3Var) {
            this.f418a = b3Var;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            if (i2Var.b() != d3.a.TEST_ADS.ordinal()) {
                k7.a(o2Var.c(), o2Var.b(), c3.this);
                return;
            }
            com.applovin.impl.sdk.k o = this.f418a.o();
            b3.b y = this.f418a.y();
            if (!c3.this.f417a.a(i2Var)) {
                k7.a(o2Var.c(), o2Var.b(), c3.this);
                return;
            }
            if (b3.b.READY == y) {
                d.a(c3.this, MaxDebuggerMultiAdActivity.class, o.e(), new C0092a());
            } else if (b3.b.DISABLED != y) {
                k7.a(o2Var.c(), o2Var.b(), c3.this);
            } else {
                o.t0().a();
                k7.a(o2Var.c(), o2Var.b(), c3.this);
            }
        }
    }

    public c3() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        d3 d3Var = this.f417a;
        if (d3Var != null) {
            return d3Var.h().o();
        }
        return null;
    }

    public void initialize(b3 b3Var) {
        setTitle(b3Var.g());
        d3 d3Var = new d3(b3Var, this);
        this.f417a = d3Var;
        d3Var.a(new a(b3Var));
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.b = listView;
        listView.setAdapter((ListAdapter) this.f417a);
    }

    @Override // com.applovin.impl.k3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f417a.h().b().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f417a.k();
            this.f417a.c();
        }
    }
}
