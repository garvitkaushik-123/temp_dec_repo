package io.bidmachine;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.XmlResourceParser;
import kotlin.KotlinVersion;

/* loaded from: classes7.dex */
public final class PlatformData {
    private static volatile PlatformData instance;
    private final Context context;
    final String kotlinVersion = getKotlinVersion();
    private Integer minSdkVersion;

    public static PlatformData get(Context context) {
        PlatformData platformData;
        PlatformData platformData2 = instance;
        if (platformData2 != null) {
            return platformData2;
        }
        synchronized (PlatformData.class) {
            platformData = instance;
            if (platformData == null) {
                platformData = new PlatformData(context);
                instance = platformData;
            }
        }
        return platformData;
    }

    private PlatformData(Context context) {
        this.context = context.getApplicationContext();
    }

    Integer getMinSdkVersion() {
        Integer num = this.minSdkVersion;
        if (num != null) {
            return num;
        }
        Integer minSdkVersionFromApplicationInfo = getMinSdkVersionFromApplicationInfo(this.context);
        this.minSdkVersion = minSdkVersionFromApplicationInfo;
        if (minSdkVersionFromApplicationInfo == null) {
            this.minSdkVersion = getMinSdkVersionFromManifest(this.context);
        }
        return this.minSdkVersion;
    }

    private Integer getMinSdkVersionFromApplicationInfo(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo;
            if (applicationInfo != null) {
                return Integer.valueOf(applicationInfo.minSdkVersion);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private Integer getMinSdkVersionFromManifest(Context context) {
        Integer num = null;
        try {
            XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            try {
                for (int eventType = openXmlResourceParser.getEventType(); eventType != 1; eventType = openXmlResourceParser.next()) {
                    if (eventType == 2) {
                        if ("uses-sdk".equals(openXmlResourceParser.getName())) {
                            int i = 0;
                            while (true) {
                                if (i >= openXmlResourceParser.getAttributeCount()) {
                                    break;
                                }
                                if ("minSdkVersion".equals(openXmlResourceParser.getAttributeName(i))) {
                                    num = Integer.valueOf(Integer.parseInt(openXmlResourceParser.getAttributeValue(i)));
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                }
                if (openXmlResourceParser != null) {
                    openXmlResourceParser.close();
                }
                return num;
            } finally {
            }
        } catch (Exception unused) {
            return num;
        }
    }

    private String getKotlinVersion() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
