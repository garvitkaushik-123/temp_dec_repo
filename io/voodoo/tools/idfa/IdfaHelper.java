package io.voodoo.tools.idfa;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: classes8.dex */
public class IdfaHelper {
    private static IdfaHelper _instance;
    private String _idfa;
    private boolean _isGetIdfaCalled = false;

    public static IdfaHelper getInstance() {
        if (_instance == null) {
            _instance = new IdfaHelper();
        }
        return _instance;
    }

    private String obtainIdfaFromGoogleService(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (!advertisingIdInfo.isLimitAdTrackingEnabled() && advertisingIdInfo.getId() != null) {
                return advertisingIdInfo.getId();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getIdfa(Context context) {
        if (!this._isGetIdfaCalled) {
            this._idfa = obtainIdfaFromGoogleService(context);
            this._isGetIdfaCalled = true;
        }
        return this._idfa;
    }
}
