package com.ironsource.sdk.service.Connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.ironsource.C2986a4;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC3279r7;
import com.ironsource.InterfaceC3296s7;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class BroadcastReceiverStrategy implements InterfaceC3279r7 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3296s7 f3824a;
    private BroadcastReceiver b = new BroadcastReceiver() { // from class: com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String b = C2986a4.b(context);
            if (b.equals("none")) {
                BroadcastReceiverStrategy.this.f3824a.a();
            } else {
                BroadcastReceiverStrategy.this.f3824a.a(b, new JSONObject());
            }
        }
    };

    public BroadcastReceiverStrategy(InterfaceC3296s7 interfaceC3296s7) {
        this.f3824a = interfaceC3296s7;
    }

    @Override // com.ironsource.InterfaceC3279r7
    public void a(Context context) {
        try {
            context.unregisterReceiver(this.b);
        } catch (IllegalArgumentException e) {
            C3260q4.d().a(e);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e2);
        }
    }

    @Override // com.ironsource.InterfaceC3279r7
    public void b(Context context) {
        try {
            context.registerReceiver(this.b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    @Override // com.ironsource.InterfaceC3279r7
    public JSONObject c(Context context) {
        return new JSONObject();
    }

    @Override // com.ironsource.InterfaceC3279r7
    public void a() {
        this.b = null;
    }
}
