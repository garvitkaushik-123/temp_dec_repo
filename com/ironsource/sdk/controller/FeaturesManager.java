package com.ironsource.sdk.controller;

import com.ironsource.Be;
import com.ironsource.C3040d4;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.InterfaceC3196m8;
import com.ironsource.Q3;
import com.ironsource.R3;
import com.ironsource.Z6;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class FeaturesManager {
    private static volatile FeaturesManager d = null;
    private static final String e = "debugMode";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, ?> f3702a;
    private final ArrayList<String> b = new a();
    private InterfaceC3196m8 c = C3334ub.U().t();

    class a extends ArrayList<String> {
        a() {
            add(C3040d4.d.f);
            add(C3040d4.d.e);
            add(C3040d4.d.g);
            add(C3040d4.d.h);
            add(C3040d4.d.i);
            add(C3040d4.d.j);
            add(C3040d4.d.k);
            add(C3040d4.d.l);
            add(C3040d4.d.m);
        }
    }

    private FeaturesManager() {
        if (d != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        this.f3702a = new HashMap();
    }

    public static FeaturesManager getInstance() {
        if (d == null) {
            synchronized (FeaturesManager.class) {
                if (d == null) {
                    d = new FeaturesManager();
                }
            }
        }
        return d;
    }

    ArrayList<String> a() {
        return new ArrayList<>(this.b);
    }

    public JSONObject getDataManagerConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return networkConfiguration.has(C3040d4.a.d) ? networkConfiguration.optJSONObject(C3040d4.a.d) : new JSONObject();
    }

    public int getDebugMode() {
        Integer num = 0;
        try {
            if (this.f3702a.containsKey("debugMode")) {
                num = (Integer) this.f3702a.get("debugMode");
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public Q3 getFeatureFlagCatchUrlError() {
        return new Q3(SDKUtils.getNetworkConfiguration().optJSONObject(Q3.a.c));
    }

    public R3 getFeatureFlagClickCheck() {
        return new R3(SDKUtils.getNetworkConfiguration());
    }

    public Z6 getFeatureFlagHealthCheck() {
        JSONObject a2 = this.c.a(C3040d4.a.r);
        return a2 instanceof JSONObject ? new Z6(a2) : new Z6(null);
    }

    public int getInitRecoverTrials() {
        JSONObject optJSONObject = SDKUtils.getNetworkConfiguration().optJSONObject(C3040d4.a.f);
        if (optJSONObject != null) {
            return optJSONObject.optInt(C3040d4.a.e, 0);
        }
        return 0;
    }

    public Be getSessionHistoryConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return new Be(networkConfiguration.has(C3040d4.a.s) ? networkConfiguration.optJSONObject(C3040d4.a.s) : new JSONObject());
    }

    public boolean getStopUseOnResumeAndPause() {
        return Boolean.TRUE.equals(this.c.c(C3040d4.a.u));
    }

    public void updateDebugConfigurations(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.f3702a = map;
    }
}
