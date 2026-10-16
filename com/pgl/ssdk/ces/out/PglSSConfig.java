package com.pgl.ssdk.ces.out;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes6.dex */
public final class PglSSConfig {
    public static final int COLLECT_MODE_DEFAULT = 0;
    public static final int COLLECT_MODE_ML_MINIMIZE = 1;
    public static final String CUSTOMINFO_KEY_ALLOWED_FIELDS = "fields_allowed";
    public static final String CUSTOMINFO_KEY_CHECKCLAZZ = "check_clz";
    public static final String CUSTOMINFO_KEY_IPV6 = "key_ipv6";
    public static final String CUSTOMINFO_KEY_SEC_CONFIG_STR = "sec_config";
    public static final String CUSTOMINFO_KEY_TARGET_IDC = "target-idc";
    public static final String CUSTOMINFO_KEY_TRANSFER_HOST = "key_transfer_host";
    public static final int OVREGION_TYPE_SG = 2;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f6384a;
    private final int b;
    private final int c;
    private String d;
    private Map<String, Object> e;
    private PglSSCallBack f;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f6385a;
        private int b = -1;
        private int c = 0;
        private String d;

        public PglSSConfig build() {
            if (TextUtils.isEmpty(this.f6385a)) {
                return null;
            }
            return new PglSSConfig(this.f6385a, this.b, this.c, this.d);
        }

        public Builder setAdsdkVersion(String str) {
            this.d = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.f6385a = str;
            return this;
        }

        public Builder setCollectMode(int i) {
            this.c = i;
            return this;
        }

        public Builder setOVRegionType(int i) {
            this.b = i;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAdSdkVersion() {
        return this.d;
    }

    public String getAppId() {
        return this.f6384a;
    }

    public PglSSCallBack getCallBack() {
        return this.f;
    }

    public int getCollectMode() {
        return this.c;
    }

    public Map<String, Object> getCustomInfo() {
        return this.e;
    }

    public int getOVRegionType() {
        return this.b;
    }

    public void setCallBack(PglSSCallBack pglSSCallBack) {
        this.f = pglSSCallBack;
    }

    public void setCustomInfo(Map<String, Object> map) {
        this.e = map;
    }

    private PglSSConfig(String str, int i, int i2, String str2) {
        this.f6384a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
    }
}
