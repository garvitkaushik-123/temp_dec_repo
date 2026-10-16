package com.unity3d.services.ads.gmascar.bridges.mobileads;

import android.content.Context;
import com.unity3d.services.core.reflection.GenericBridge;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class MobileAdsBridgeBase extends GenericBridge implements IMobileAdsBridge {
    public static final String initializationStatusMethodName = "getInitializationStatus";
    public static final String initializeMethodName = "initialize";

    public abstract boolean hasSCARBiddingSupport();

    public MobileAdsBridgeBase(Map<String, Class<?>[]> map) {
        super(map);
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.google.android.gms.ads.MobileAds";
    }

    @Override // com.unity3d.services.ads.gmascar.bridges.mobileads.IMobileAdsBridge
    public void initialize(Context context, Object obj) {
        callVoidMethod(initializeMethodName, null, context, obj);
    }

    @Override // com.unity3d.services.ads.gmascar.bridges.mobileads.IMobileAdsBridge
    public Object getInitializationStatus() {
        return callNonVoidMethod(initializationStatusMethodName, null, new Object[0]);
    }

    @Override // com.unity3d.services.ads.gmascar.bridges.mobileads.IMobileAdsBridge
    public String getVersionString() {
        Object callNonVoidMethod = callNonVoidMethod(getVersionMethodName(), null, new Object[0]);
        if (callNonVoidMethod == null) {
            return "0.0.0";
        }
        return callNonVoidMethod.toString();
    }
}
