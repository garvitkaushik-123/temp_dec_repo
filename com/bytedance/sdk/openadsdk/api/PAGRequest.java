package com.bytedance.sdk.openadsdk.api;

import android.os.Bundle;
import java.util.Map;

/* loaded from: classes3.dex */
public class PAGRequest {
    private Map<String, Object> DbA;
    private Bundle Os = null;
    private String eli;

    public String getAdString() {
        return this.eli;
    }

    public void setAdString(String str) {
        this.eli = str;
    }

    public Map<String, Object> getExtraInfo() {
        return this.DbA;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.DbA = map;
    }

    public final void addNetworkExtrasBundle(Class<?> cls, Bundle bundle) {
        if (this.Os == null) {
            this.Os = new Bundle();
        }
        this.Os.putBundle(cls.getName(), bundle);
    }

    public Bundle getNetworkExtrasBundle() {
        return this.Os;
    }
}
