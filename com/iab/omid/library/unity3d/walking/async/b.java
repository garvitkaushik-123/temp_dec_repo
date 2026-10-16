package com.iab.omid.library.unity3d.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class b extends AsyncTask<Object, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    private a f2133a;
    protected final InterfaceC0271b b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.unity3d.walking.async.b$b, reason: collision with other inner class name */
    public interface InterfaceC0271b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(InterfaceC0271b interfaceC0271b) {
        this.b = interfaceC0271b;
    }

    public void a(a aVar) {
        this.f2133a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        a aVar = this.f2133a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
