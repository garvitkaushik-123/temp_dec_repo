package com.digitalturbine.ignite.authenticator.utils.events;

import android.text.TextUtils;
import android.util.Pair;
import com.digitalturbine.ignite.authenticator.events.c;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class a {
    public static Object[] a(Throwable th, c cVar) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new Pair("exception_name", th.getClass().getSimpleName()));
        arrayList.add(new Pair("description", th.getMessage()));
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringBuffer = stringWriter.getBuffer().toString();
        if (!TextUtils.isEmpty(stringBuffer)) {
            arrayList.add(new Pair("stack_trace", stringBuffer));
        }
        if (cVar != null) {
            arrayList.add(new Pair(AndroidBridgeConstants.ERROR_CODE, cVar.a()));
        }
        Object[] objArr = new Object[arrayList.size() * 2];
        int i = 1;
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Pair pair = (Pair) arrayList.get(i3);
            objArr[i2] = pair.first;
            objArr[i] = pair.second;
            i2 += 2;
            i += 2;
        }
        return objArr;
    }
}
