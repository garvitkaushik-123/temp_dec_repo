package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class g implements com.fyber.inneractive.sdk.response.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f1270a;
    public final /* synthetic */ i b;

    public g(List list, i iVar) {
        this.f1270a = list;
        this.b = iVar;
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public final List a(x xVar) {
        if (xVar == null || this.f1270a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f1270a) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str.replace("[REASON]", String.valueOf(this.b.mReason)));
            }
        }
        return arrayList;
    }
}
