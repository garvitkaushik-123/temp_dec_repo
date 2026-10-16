package com.pgl.ssdk.ces.out;

import android.content.Context;
import android.view.MotionEvent;
import com.pgl.ssdk.ces.b;
import java.util.Map;

/* loaded from: classes6.dex */
public class PglSSManager {
    public static final int INIT_STATUS_FAIL_CONTEXT_NULL = 4;
    public static final int INIT_STATUS_FAIL_SO_LOADFAIL = 3;
    public static final int INIT_STATUS_FAIL_SO_MISSING = 2;
    public static final int INIT_STATUS_OK = 0;
    public static final int INIT_STATUS_UNINITIALIZE = 1;
    public static final String REPORT_SCENE_ADSHOW = "AdShow";

    /* renamed from: a, reason: collision with root package name */
    private static volatile PglSSManager f6386a;
    private final b b;
    private volatile int c = 0;
    private volatile PglSSCallBack d;

    private PglSSManager(Context context, PglSSConfig pglSSConfig) {
        this.b = b.a(context, pglSSConfig.getAppId(), pglSSConfig.getOVRegionType(), pglSSConfig.getCollectMode(), pglSSConfig.getAdSdkVersion());
    }

    public static int getInitStatus() {
        return b.g();
    }

    public static PglSSManager getInstance() {
        return f6386a;
    }

    public static String getLoadError() {
        if (b.i() != null) {
            return b.i().b;
        }
        return null;
    }

    @DungeonFlag
    public static PglSSManager init(Context context, PglSSConfig pglSSConfig, String str, String str2, String str3, String str4) {
        if (context == null && pglSSConfig == null) {
            return null;
        }
        if (f6386a == null) {
            synchronized (PglSSManager.class) {
                if (f6386a == null) {
                    f6386a = new PglSSManager(context, pglSSConfig);
                    if (b.g() == 0) {
                        f6386a.d = pglSSConfig.getCallBack();
                        f6386a.b.a(pglSSConfig.getCustomInfo());
                        f6386a.b.a(str, str3, str2, str4);
                    }
                }
            }
        }
        return f6386a;
    }

    public void checkEventVirtual(MotionEvent motionEvent) {
        if (b.g() == 0) {
            this.b.a(motionEvent);
        }
    }

    public long getECForBidding() {
        if (b.g() == 0) {
            return this.b.e();
        }
        return 0L;
    }

    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        if (b.g() == 0) {
            return this.b.a(str, bArr);
        }
        return null;
    }

    public PglSSCallBack getPglCallBack() {
        return this.d;
    }

    public String getSofChara() {
        if (b.g() == 0) {
            return this.b.j();
        }
        return null;
    }

    public String getToken() {
        if (b.g() == 0) {
            return this.b.k();
        }
        return null;
    }

    public void reportNow(String str, Map<String, Object> map) {
        if (b.g() == 0) {
            if (REPORT_SCENE_ADSHOW.equals(str)) {
                this.b.b();
            }
            int i = this.c;
            b bVar = this.b;
            if (i % bVar.p == 0) {
                bVar.a(str, map);
            }
            this.c++;
        }
    }

    public void setCustomInfo(Map<String, Object> map) {
        if (b.g() == 0) {
            this.b.a(map);
        }
    }

    public void setDeviceId(String str) {
        if (b.g() == 0) {
            this.b.b(str);
        }
    }

    public void setGaid(String str) {
        if (b.g() == 0) {
            this.b.c(str);
        }
    }
}
