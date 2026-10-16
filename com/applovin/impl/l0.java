package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.o2;
import com.applovin.impl.p2;
import com.applovin.impl.x6;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class l0 extends k3 {

    /* renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f522a;
    private p2 b;

    class a extends p2 {
        final /* synthetic */ List e;
        final /* synthetic */ List f;
        final /* synthetic */ List g;
        final /* synthetic */ List h;
        final /* synthetic */ List i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list, List list2, List list3, List list4, List list5) {
            super(context);
            this.e = list;
            this.f = list2;
            this.g = list3;
            this.h = list4;
            this.i = list5;
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return c.values().length;
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            List list;
            boolean z = true;
            if (i == c.MISSING_TC_NETWORKS.ordinal()) {
                list = this.e;
            } else if (i == c.MISSING_AC_NETWORKS.ordinal()) {
                list = this.f;
            } else {
                z = false;
                list = i == c.LISTED_TC_NETWORKS.ordinal() ? this.g : i == c.LISTED_AC_NETWORKS.ordinal() ? this.h : this.i;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(l0.this.a((x6) it.next(), z));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return i == c.MISSING_TC_NETWORKS.ordinal() ? this.e.size() : i == c.MISSING_AC_NETWORKS.ordinal() ? this.f.size() : i == c.LISTED_TC_NETWORKS.ordinal() ? this.g.size() : i == c.LISTED_AC_NETWORKS.ordinal() ? this.h.size() : this.i.size();
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return i == c.MISSING_TC_NETWORKS.ordinal() ? new t4("MISSING TCF VENDORS (TC STRING)") : i == c.MISSING_AC_NETWORKS.ordinal() ? new t4("MISSING ATP NETWORKS (AC STRING)") : i == c.LISTED_TC_NETWORKS.ordinal() ? new t4("LISTED TCF VENDORS (TC STRING)") : i == c.LISTED_AC_NETWORKS.ordinal() ? new t4("LISTED ATP NETWORKS (AC STRING)") : new t4("NON-CONFIGURABLE NETWORKS");
        }
    }

    class b implements p2.a {
        b() {
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            k7.a(o2Var.c(), o2Var.b(), l0.this);
        }
    }

    private enum c {
        MISSING_TC_NETWORKS,
        MISSING_AC_NETWORKS,
        LISTED_TC_NETWORKS,
        LISTED_AC_NETWORKS,
        OTHER_NETWORKS
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f522a;
    }

    public void initialize(List<x6> list, List<x6> list2, List<x6> list3, List<x6> list4, List<x6> list5, com.applovin.impl.sdk.k kVar) {
        this.f522a = kVar;
        a aVar = new a(this, list, list2, list3, list4, list5);
        this.b = aVar;
        aVar.a(new b());
        this.b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Configured CMP Networks");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o2 a(x6 x6Var, boolean z) {
        o2.b a2 = o2.a();
        boolean b2 = this.f522a.s0().b();
        x6.a f = x6Var.f();
        x6.a aVar = x6.a.TCF_VENDOR;
        if (f == aVar || (x6Var.f() == x6.a.ATP_NETWORK && b2)) {
            String c2 = x6Var.c();
            a2.d(c2).d(z ? -65536 : -16777216).b(c2).a((x6Var.f() == aVar ? "IAB Vendor ID: " : "Google ATP ID: ") + x6Var.d()).a(true);
        } else {
            a2.d(x6Var.b());
        }
        return a2.a();
    }
}
