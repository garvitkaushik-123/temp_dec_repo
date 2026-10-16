package com.ironsource;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import org.json.JSONObject;

/* renamed from: com.ironsource.re, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3286re {

    /* renamed from: com.ironsource.re$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3682a;
        final /* synthetic */ boolean b;
        final /* synthetic */ int c;

        a(String str, boolean z, int i) {
            this.f3682a = str;
            this.b = z;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3286re.b(this.f3682a, this.b, this.c);
        }
    }

    public static void a(String str, boolean z, int i) {
        Thread thread = new Thread(new a(str, z, i), "callAsyncRequestURL");
        thread.setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.d());
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, boolean z, int i) {
        try {
            new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getRequestURL(str, z, i)));
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NETWORK, "callRequestURL(reqUrl:" + str + ", hit:" + z + ")", 1);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            StringBuilder sb = new StringBuilder("callRequestURL(reqUrl:");
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", hit:").append(z).append(")");
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NETWORK, sb.toString() + ", e:" + Log.getStackTraceString(th), 0);
        }
    }
}
