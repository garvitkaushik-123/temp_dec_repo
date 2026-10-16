package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.d;
import com.applovin.impl.o2;
import com.applovin.impl.p2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerAdUnitWaterfallsListActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class q extends k3 {

    /* renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f630a;
    private p2 b;
    private List c;
    private boolean d;
    private ListView e;

    class a extends p2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.e = list;
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            return q.this.c;
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return this.e.size();
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return new t4("");
        }
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f630a;
    }

    public void initialize(final List<n> list, boolean z, final com.applovin.impl.sdk.k kVar) {
        this.d = z;
        this.f630a = kVar;
        this.c = a(list);
        a aVar = new a(this, list);
        this.b = aVar;
        aVar.a(new p2.a() { // from class: com.applovin.impl.q$$ExternalSyntheticLambda2
            @Override // com.applovin.impl.p2.a
            public final void a(i2 i2Var, o2 o2Var) {
                q.this.a(list, kVar, i2Var, o2Var);
            }
        });
        this.b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle((this.d ? "Selective Init " : "").concat("Ad Units"));
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.e = listView;
        listView.setAdapter((ListAdapter) this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, final com.applovin.impl.sdk.k kVar, i2 i2Var, o2 o2Var) {
        final n nVar = (n) list.get(i2Var.a());
        if (nVar.g().size() == 1) {
            d.a(this, MaxDebuggerAdUnitDetailActivity.class, kVar.e(), new d.b() { // from class: com.applovin.impl.q$$ExternalSyntheticLambda0
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    ((MaxDebuggerAdUnitDetailActivity) activity).initialize(n.this, null, null, kVar);
                }
            });
        } else {
            d.a(this, MaxDebuggerAdUnitWaterfallsListActivity.class, kVar.e(), new d.b() { // from class: com.applovin.impl.q$$ExternalSyntheticLambda1
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    ((MaxDebuggerAdUnitWaterfallsListActivity) activity).initialize(n.this, kVar);
                }
            });
        }
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(nVar.c(), -16777216));
            spannableStringBuilder.append((CharSequence) new SpannedString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(nVar.b(), -16777216));
            arrayList.add(o2.a(o2.c.DETAIL).b(StringUtils.createSpannedString(nVar.d(), -16777216, 18, 1)).a(new SpannedString(spannableStringBuilder)).a(this).a(true).a());
        }
        return arrayList;
    }
}
