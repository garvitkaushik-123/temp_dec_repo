package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.o2;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class g8 extends k3 {

    /* renamed from: a, reason: collision with root package name */
    private String f466a;
    private com.applovin.impl.sdk.k b;
    private p2 c;

    class a extends p2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.e = list;
        }

        @Override // com.applovin.impl.p2
        protected o2 a() {
            return new o2.b(o2.c.SECTION_CENTERED).d("A plus in front of each segment indicates inclusion and a minus indicates exclusion. The comma in comma-separated values functions as an ∨ (or) operator, and a new row functions as an ∧ (and) operator.").a();
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            return this.e;
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return this.e.size();
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return new t4("SEGMENT TARGETING");
        }
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(o2.a(o2.c.DETAIL).d((String) it.next()).a());
        }
        return arrayList;
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.b;
    }

    public void initialize(String str, List<String> list, com.applovin.impl.sdk.k kVar) {
        this.f466a = str;
        this.b = kVar;
        a aVar = new a(this, a(list));
        this.c = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f466a);
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.c);
    }
}
