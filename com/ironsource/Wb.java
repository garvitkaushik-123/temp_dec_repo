package com.ironsource;

import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class Wb {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3111a = new a();
        public static final String b = "SDKPluginType";
        public static final String c = "sessionid";

        private a() {
        }
    }

    public final Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String pluginType = ConfigFile.getConfigFile().getPluginType();
        if (pluginType != null) {
            linkedHashMap.put(a.b, pluginType);
        }
        String sessionId = IronSourceUtils.getSessionId();
        if (sessionId != null) {
            linkedHashMap.put("sessionid", sessionId);
        }
        return linkedHashMap;
    }
}
