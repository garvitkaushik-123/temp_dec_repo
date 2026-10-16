package com.iab.omid.library.bytedance2.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    private a f1950a;
    protected final InterfaceC0251b b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.bytedance2.walking.async.b$b, reason: collision with other inner class name */
    public interface InterfaceC0251b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0251b interfaceC0251b) {
        this.b = interfaceC0251b;
    }

    public void a(a aVar) {
        this.f1950a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f1950a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
