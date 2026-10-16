package com.unity3d.services.store.gpbl.bridges;

/* loaded from: classes7.dex */
public class SkuDetailsBridge extends CommonJsonResponseBridge {
    public SkuDetailsBridge(Object obj) {
        super(obj);
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.SkuDetails";
    }
}
