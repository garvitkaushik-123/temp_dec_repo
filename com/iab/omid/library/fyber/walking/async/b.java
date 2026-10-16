package com.iab.omid.library.fyber.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    private a f1987a;
    protected final InterfaceC0255b b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.fyber.walking.async.b$b, reason: collision with other inner class name */
    public interface InterfaceC0255b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0255b interfaceC0255b) {
        this.b = interfaceC0255b;
    }

    public void a(a aVar) {
        this.f1987a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f1987a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
