package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.io.File;

/* loaded from: classes6.dex */
public class HTMLResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    private static final String TAG = "HTMLResourceManager";
    private String mFileSaveSDDir;

    private static class ResourceManagerHolder {
        public static HTMLResourceManager instance = new HTMLResourceManager();

        private ResourceManagerHolder() {
        }
    }

    public static HTMLResourceManager getInstance() {
        return ResourceManagerHolder.instance;
    }

    public void cleanHtmlRes() {
        try {
            if (TextUtils.isEmpty(this.mFileSaveSDDir)) {
                return;
            }
            DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.HTMLResourceManager.1
                @Override // com.mbridge.msdk.foundation.same.task.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.task.a
                public void pauseTask(boolean z) {
                }

                @Override // com.mbridge.msdk.foundation.same.task.a
                public void runTask() {
                    n0.a(HTMLResourceManager.this.mFileSaveSDDir);
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public String getHtmlContentFromUrl(String str) {
        try {
            File file = new File(this.mFileSaveSDDir + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(b1.b(str)) + ".html");
            if (file.exists()) {
                return n0.e(file);
            }
            return null;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public String getHtmlPathFromUrl(String str) {
        try {
            String str2 = this.mFileSaveSDDir + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(b1.b(str)) + ".html";
            File file = new File(str2);
            if (!file.exists()) {
                return null;
            }
            g d = h.b().d(c.m().b());
            if (d != null && !TextUtils.isEmpty(d.T())) {
                d.a(str, file);
            }
            return "file:////" + str2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
    }

    public boolean saveResHtmlFile(String str, byte[] bArr) {
        try {
            p0.c(TAG, "saveResHtmlFile url:" + str);
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            String str2 = this.mFileSaveSDDir + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(b1.b(str)) + ".html";
            p0.c(TAG, "saveResHtmlFile folderName:" + str2);
            return n0.a(bArr, new File(str2));
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    private HTMLResourceManager() {
        init();
    }
}
