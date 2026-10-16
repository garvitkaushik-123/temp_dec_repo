package com.applovin.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class y {
    private static y e;
    private static final Object f = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f787a;
    private final int b;
    private final boolean c;
    private final String d;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private y(Context context) {
        Bundle bundle;
        int i;
        XmlResourceParser openXmlResourceParser;
        int eventType;
        String str = null;
        str = null;
        try {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                bundle = applicationInfo.metaData;
                try {
                    String str2 = applicationInfo.processName;
                    this.f787a = bundle;
                    this.d = str2;
                } catch (PackageManager.NameNotFoundException e2) {
                    e = e2;
                    com.applovin.impl.sdk.o.c("AndroidManifest", "Failed to get meta data.", e);
                    this.f787a = bundle;
                    this.d = null;
                    str = null;
                    boolean z = false;
                    openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
                    eventType = openXmlResourceParser.getEventType();
                    i = 0;
                    boolean z2 = false;
                    do {
                        if (2 == eventType) {
                        }
                        eventType = openXmlResourceParser.next();
                    } while (eventType != 1);
                    this.b = i;
                    this.c = z2;
                }
            } catch (Throwable th) {
                th = th;
                this.f787a = bundle;
                this.d = str;
                throw th;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
            bundle = null;
        } catch (Throwable th2) {
            th = th2;
            bundle = null;
            this.f787a = bundle;
            this.d = str;
            throw th;
        }
        str = null;
        boolean z3 = false;
        try {
            openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            eventType = openXmlResourceParser.getEventType();
            i = 0;
            boolean z22 = false;
            do {
                if (2 == eventType) {
                    try {
                        if (openXmlResourceParser.getName().equals("application")) {
                            for (int i2 = 0; i2 < openXmlResourceParser.getAttributeCount(); i2++) {
                                String attributeName = openXmlResourceParser.getAttributeName(i2);
                                String attributeValue = openXmlResourceParser.getAttributeValue(i2);
                                if (attributeName.equals("networkSecurityConfig")) {
                                    i = Integer.valueOf(attributeValue.substring(1)).intValue();
                                } else if (attributeName.equals("usesCleartextTraffic")) {
                                    z22 = Boolean.valueOf(attributeValue).booleanValue();
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z3 = z22;
                        try {
                            com.applovin.impl.sdk.o.c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                            return;
                        } finally {
                            this.b = i;
                            this.c = z3;
                        }
                    }
                }
                eventType = openXmlResourceParser.next();
            } while (eventType != 1);
            this.b = i;
            this.c = z22;
        } catch (Throwable th4) {
            th = th4;
            i = 0;
        }
    }

    public static y a(Context context) {
        y yVar;
        synchronized (f) {
            if (e == null) {
                e = new y(context);
            }
            yVar = e;
        }
        return yVar;
    }

    public boolean a(String str) {
        Bundle bundle = this.f787a;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public boolean a(String str, boolean z) {
        Bundle bundle = this.f787a;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }

    public String a() {
        return this.d;
    }
}
