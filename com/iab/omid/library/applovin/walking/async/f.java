package com.iab.omid.library.applovin.walking.async;

import android.text.TextUtils;
import com.iab.omid.library.applovin.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f extends a {
    public f(b.InterfaceC0243b interfaceC0243b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0243b, hashSet, jSONObject, j);
    }

    private void b(String str) {
        com.iab.omid.library.applovin.internal.c c = com.iab.omid.library.applovin.internal.c.c();
        if (c != null) {
            for (com.iab.omid.library.applovin.adsession.a aVar : c.b()) {
                if (this.c.contains(aVar.c())) {
                    aVar.d().b(str, this.e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        if (com.iab.omid.library.applovin.utils.c.h(this.d, this.b.a())) {
            return null;
        }
        this.b.a(this.d);
        return this.d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.applovin.walking.async.b, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        super.onPostExecute(str);
    }
}
