package com.mbridge.msdk.mbnative.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: NativeConst.java */
/* loaded from: classes6.dex */
public class a {
    public static String a(Exception exc) {
        if (exc == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
