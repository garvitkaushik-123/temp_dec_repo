package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.autofill.HintConstants;
import com.applovin.impl.d;
import com.applovin.impl.o2;
import com.applovin.impl.p2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerWaterfallSegmentsActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class p extends k3 {

    /* renamed from: a, reason: collision with root package name */
    private n f612a;
    private com.applovin.impl.sdk.k b;
    private p2 c;

    class a extends p2 {
        final /* synthetic */ n e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, n nVar) {
            super(context);
            this.e = nVar;
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return this.e.g().size();
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            ArrayList arrayList = new ArrayList();
            o oVar = (o) this.e.g().get(i);
            arrayList.add(p.this.c(oVar.c()));
            if (oVar.b() != null) {
                arrayList.add(p.this.a("AB Test Experiment Name", oVar.b()));
            }
            h8 d = oVar.d();
            p pVar = p.this;
            arrayList.add(pVar.a("Device ID Targeting", pVar.a(d.a())));
            p pVar2 = p.this;
            arrayList.add(pVar2.a("Device Type Targeting", pVar2.b(d.b())));
            if (d.c() != null) {
                arrayList.add(p.this.a(d.c()));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            o oVar = (o) this.e.g().get(i);
            return (oVar.b() != null ? 1 : 0) + 3 + (oVar.d().c() == null ? 0 : 1);
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return i == b.TARGETED_WATERFALL.ordinal() ? new t4("TARGETED WATERFALL FOR CURRENT DEVICE") : i == b.OTHER_WATERFALLS.ordinal() ? new t4("OTHER WATERFALLS") : new t4("");
        }
    }

    public enum b {
        TARGETED_WATERFALL,
        OTHER_WATERFALLS
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.b;
    }

    public void initialize(final n nVar, final com.applovin.impl.sdk.k kVar) {
        this.f612a = nVar;
        this.b = kVar;
        a aVar = new a(this, nVar);
        this.c = aVar;
        aVar.a(new p2.a() { // from class: com.applovin.impl.p$$ExternalSyntheticLambda2
            @Override // com.applovin.impl.p2.a
            public final void a(i2 i2Var, o2 o2Var) {
                p.this.a(kVar, nVar, i2Var, o2Var);
            }
        });
        this.c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f612a.d());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.c);
        listView.setDividerHeight(0);
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        p2 p2Var = this.c;
        if (p2Var != null) {
            p2Var.a((p2.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        return str.equals(HintConstants.AUTOFILL_HINT_PHONE) ? "Phones" : str.equals("tablet") ? "Tablets" : "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o2 c(String str) {
        return o2.a(o2.c.RIGHT_DETAIL).b(StringUtils.createSpannedString(str, -16777216, 18, 1)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.k kVar, final n nVar, final i2 i2Var, o2 o2Var) {
        if (i2Var.a() == 0) {
            d.a(this, MaxDebuggerAdUnitDetailActivity.class, kVar.e(), new d.b() { // from class: com.applovin.impl.p$$ExternalSyntheticLambda0
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    p.a(n.this, i2Var, kVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        } else {
            d.a(this, MaxDebuggerWaterfallSegmentsActivity.class, kVar.e(), new d.b() { // from class: com.applovin.impl.p$$ExternalSyntheticLambda1
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    p.a(n.this, i2Var, kVar, (MaxDebuggerWaterfallSegmentsActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(n nVar, i2 i2Var, com.applovin.impl.sdk.k kVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(nVar, (o) nVar.g().get(i2Var.b()), null, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(n nVar, i2 i2Var, com.applovin.impl.sdk.k kVar, MaxDebuggerWaterfallSegmentsActivity maxDebuggerWaterfallSegmentsActivity) {
        o oVar = (o) nVar.g().get(i2Var.b());
        maxDebuggerWaterfallSegmentsActivity.initialize(oVar.c(), oVar.d().c(), kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o2 a(String str, String str2) {
        return o2.a(o2.c.RIGHT_DETAIL).d(str).c(str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o2 a(List list) {
        return o2.a(o2.c.DETAIL).d("Segment Targeting").a(StringUtils.createSpannedString(list.size() + " segment group(s)", -7829368, 14)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (str.equals("idfa")) {
            return "IDFA Only";
        }
        if (str.equals("dnt")) {
            return "No IDFA Only";
        }
        return "All";
    }
}
