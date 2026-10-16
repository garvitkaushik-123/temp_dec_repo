package com.bytedance.sdk.openadsdk.api.init;

import android.text.TextUtils;
import com.bykv.vk.openvk.eli.eli.eli.Os;
import com.bytedance.sdk.component.kb.Os.Os;
import com.bytedance.sdk.component.utils.Dfc;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.core.GB;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public final class PAGConfig implements InitConfig {
    private static String aAs;
    private boolean DbA;
    private String FC;
    private int Os;
    private String du;
    private String eli;
    private boolean kb;
    private String wC;
    private int aGH = -1;
    private int ui = -1;
    private int MGA = 0;

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isUseTextureView() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getData() {
        return this.FC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str) {
        this.FC = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAppId() {
        return this.eli;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(String str) {
        this.eli = str;
    }

    public boolean getDebugLog() {
        return this.DbA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(boolean z) {
        this.DbA = z;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getAppIconId() {
        return this.Os;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i) {
        this.Os = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.aGH = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getGdpr() {
        return this.aGH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(int i) {
        this.ui = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getPA() {
        return this.ui;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getTitleBarTheme() {
        return this.MGA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH(int i) {
        this.MGA = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isSupportMultiProcess() {
        return this.kb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(boolean z) {
        this.kb = z;
        Os.eli(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(String str) {
        this.wC = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getPackageName() {
        if (TextUtils.isEmpty(this.wC)) {
            return aAs;
        }
        return this.wC;
    }

    public static void setGDPRConsent(int i) {
        dZ.FC("setGdpr");
        if (i < -1 || i > 1) {
            i = -1;
        }
        GB.eli().DbA(i);
    }

    public static int getGDPRConsent() {
        if (!dZ.FC("getGdpr")) {
            return -1;
        }
        int DbA = GB.eli().DbA();
        if (DbA == 1) {
            return 0;
        }
        if (DbA == 0) {
            return 1;
        }
        return DbA;
    }

    public static void setPAConsent(int i) {
        if (dZ.FC("setPAConsent")) {
            if (i == 1 || i == 0) {
                GB.eli().ui(i);
            } else {
                GB.eli().ui(-2);
            }
        }
    }

    public static int getPAConsent() {
        if (dZ.FC("getPAConsent")) {
            return GB.eli().ui();
        }
        return -1;
    }

    public static void debugLog(boolean z) {
        if (GB.eli() != null) {
            if (z) {
                GB.eli().Os(1);
                GB.eli().eli();
                return;
            }
            GB.eli().Os(0);
            com.bytedance.sdk.component.kb.Os.Os.eli(Os.eli.OFF);
            Dfc.Os();
            com.bykv.vk.openvk.eli.eli.eli.kb.Os.DbA();
            Xb.DbA();
        }
    }

    public static void setAppIconId(int i) {
        if (GB.eli() != null) {
            GB.eli().aGH(i);
        }
    }

    public static void setUserData(String str) {
        if (GB.eli() != null) {
            GB.eli().DbA(str);
        }
    }

    public static void setPackageName(String str) {
        aAs = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAdxId() {
        return this.du;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH(String str) {
        this.du = str;
    }

    public static class Builder {
        private boolean DbA;
        private String FC;
        private int Os;
        private String aAs;
        private String eli;
        private String[] wC;
        private int aGH = -1;
        private int ui = -1;
        private int MGA = 0;
        private boolean kb = false;
        private String du = "";

        public Builder useTextureView(boolean z) {
            return this;
        }

        public Builder setUserData(String str) {
            this.aAs = str;
            return this;
        }

        public Builder appId(String str) {
            this.eli = str;
            return this;
        }

        public Builder debugLog(boolean z) {
            this.DbA = z;
            return this;
        }

        public Builder appIcon(int i) {
            this.Os = i;
            return this;
        }

        public Builder setGDPRConsent(int i) {
            this.aGH = i;
            return this;
        }

        public Builder setPAConsent(int i) {
            if (i == 0 || i == 1) {
                this.ui = i;
                return this;
            }
            this.ui = -2;
            return this;
        }

        public Builder setAdxId(String str) {
            this.du = str;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.MGA = i;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.kb = z;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.wC = strArr;
            return this;
        }

        public Builder setPackageName(String str) {
            this.FC = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.DbA(this.eli);
            pAGConfig.eli(this.Os);
            pAGConfig.aGH(this.MGA);
            pAGConfig.DbA(this.kb);
            pAGConfig.DbA(this.aGH);
            pAGConfig.Os(this.ui);
            pAGConfig.eli(this.DbA);
            pAGConfig.Os(this.FC);
            pAGConfig.eli(this.aAs);
            pAGConfig.aGH(this.du);
            return pAGConfig;
        }
    }
}
