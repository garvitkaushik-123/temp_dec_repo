package com.apm.insight.l;

import android.text.TextUtils;
import com.apm.insight.l.e;
import com.apm.insight.nativecrash.NativeImpl;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.ktor.util.date.GMTDateParser;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Stack.java */
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f300a = new StackTraceElement("", "", "", 0);

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            a(th, printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    public static StackTraceElement[] b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            a(th, arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    public static String a(Throwable th, PrintStream printStream, e.a aVar) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        } catch (Throwable unused) {
            messageDigest = null;
        }
        e eVar = new e(printStream, messageDigest, aVar);
        try {
            a(th, eVar);
        } catch (Throwable unused2) {
        }
        eVar.close();
        if (messageDigest == null) {
            return null;
        }
        byte[] digest = messageDigest.digest();
        if (digest == null || digest.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
        char[] cArr2 = new char[digest.length << 1];
        int i = 0;
        for (byte b : digest) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i += 2;
            cArr2[i2] = cArr[b & Ascii.SI];
        }
        return new String(cArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i2 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (i2 <= 256) {
                        linkedList.add(readLine);
                        sb.append(readLine).append('\n');
                    } else {
                        linkedList2.add(readLine);
                        if (linkedList2.size() > 256) {
                            linkedList2.poll();
                            i++;
                        }
                    }
                    i2++;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    com.apm.insight.a.a((Closeable) bufferedReader);
                    if (!linkedList2.isEmpty()) {
                    }
                    return sb.toString();
                }
            }
            com.apm.insight.a.a((Closeable) bufferedReader2);
        } catch (Throwable unused2) {
        }
        if (!linkedList2.isEmpty()) {
            if (i != 0) {
                sb.append("\t... skip ").append(i).append(" lines\n");
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next()).append('\n');
            }
        }
        return sb.toString();
    }

    public static JSONObject b(String str) {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!c(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        if (jSONArray2.length() > 0) {
                        }
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean c(String str) {
        Set<String> a2 = g.a();
        if (a2.contains(str)) {
            return true;
        }
        for (String str2 : a2) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            i++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (th.getMessage().contains("allocate") || th.getMessage().contains("thrown"))) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }

    private static void b(Throwable th, int i) {
        th.getClass().getName();
        String localizedMessage = th.getLocalizedMessage();
        try {
            NativeImpl.a(i, th.getClass().getName());
            if (localizedMessage != null) {
                NativeImpl.a(i, ": ");
                NativeImpl.a(i, localizedMessage);
            }
            NativeImpl.a(i, "\n");
        } catch (Throwable unused) {
        }
    }

    private static void a(StackTraceElement stackTraceElement, int i) {
        try {
            NativeImpl.a(i, "\tat ");
            NativeImpl.a(i, stackTraceElement.getClassName());
            NativeImpl.a(i, ".");
            NativeImpl.a(i, stackTraceElement.getMethodName());
            if (!stackTraceElement.isNativeMethod()) {
                if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        NativeImpl.a(i, "(");
                        NativeImpl.a(i, stackTraceElement.getFileName());
                        NativeImpl.a(i, ":");
                        NativeImpl.a(i, String.valueOf(stackTraceElement.getLineNumber()));
                        NativeImpl.a(i, ")");
                    } else {
                        NativeImpl.a(i, "(");
                        NativeImpl.a(i, stackTraceElement.getFileName());
                        NativeImpl.a(i, ")");
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    NativeImpl.a(i, "(Unknown Source:");
                    NativeImpl.a(i, String.valueOf(stackTraceElement.getLineNumber()));
                    NativeImpl.a(i, ")");
                } else {
                    NativeImpl.a(i, "(Unknown Source)");
                }
            } else {
                NativeImpl.a(i, "(Native Method)");
            }
            NativeImpl.a(i, "\n");
        } catch (Throwable unused) {
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list) {
        if (th == null) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        list.add(f300a);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (z && i2 > 256) {
                list.add(f300a);
                break;
            } else {
                list.add(stackTraceElement);
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            a(th2, list, "\t", newSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, list, "", newSetFromMap, 128);
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list, String str, Set<Throwable> set, int i) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i2 = 0;
            boolean z = stackTrace.length > i;
            list.add(f300a);
            int length = stackTrace.length;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i3];
                if (z && i4 > i) {
                    list.add(f300a);
                    break;
                } else {
                    list.add(stackTraceElement);
                    i4++;
                    i3++;
                }
            }
            if (z) {
                for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                    list.add(stackTrace[length2]);
                }
            }
            Throwable[] suppressed = th.getSuppressed();
            int length3 = suppressed.length;
            while (true) {
                int i5 = 10;
                if (i2 >= length3) {
                    break;
                }
                Throwable th2 = suppressed[i2];
                String str2 = str + "\t";
                int i6 = i / 2;
                if (i6 > 10) {
                    i5 = i6;
                }
                a(th2, list, str2, set, i5);
                i2++;
            }
            th = th.getCause();
            if (th == null) {
                return;
            }
            i /= 2;
            if (i <= 10) {
                i = 10;
            }
        }
        list.add(f300a);
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th == null) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        printWriter.println(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (z && i2 > 256) {
                printWriter.println("\t... skip " + ((stackTrace.length - i2) + RangingPosition.RSSI_UNKNOWN) + " lines");
                break;
            } else {
                printWriter.println("\tat ".concat(String.valueOf(stackTraceElement)));
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length + RangingPosition.RSSI_UNKNOWN; length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            a(th2, printWriter, "Suppressed: ", "\t", newSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, printWriter, "Caused by: ", "", newSetFromMap, 128);
        }
    }

    private static void a(Throwable th, int i, String str, String str2) {
        while (true) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            try {
                NativeImpl.a(i, str2);
                NativeImpl.a(i, str);
            } catch (Throwable unused) {
            }
            b(th, i);
            for (StackTraceElement stackTraceElement : stackTrace) {
                a(stackTraceElement, i);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i, "Suppressed: ", str2 + "\t");
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
    }

    private static void a(Throwable th, PrintWriter printWriter, String str, String str2, Set<Throwable> set, int i) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z = stackTrace.length > i;
            printWriter.println(str2 + str + th);
            int length = stackTrace.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (z && i3 > i) {
                    printWriter.println("\t... skip " + ((stackTrace.length - i3) - (i / 2)) + " lines");
                    break;
                } else {
                    printWriter.println("\tat ".concat(String.valueOf(stackTraceElement)));
                    i3++;
                    i2++;
                }
            }
            if (z) {
                for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                    printWriter.println("\tat " + stackTrace[length2]);
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                int i4 = i / 2;
                a(th2, printWriter, "Suppressed: ", str2 + "\t", set, i4 > 10 ? i4 : 10);
            }
            PrintWriter printWriter2 = printWriter;
            Set<Throwable> set2 = set;
            th = th.getCause();
            if (th == null) {
                return;
            }
            i /= 2;
            if (i <= 10) {
                i = 10;
            }
            str = "Caused by: ";
            printWriter = printWriter2;
            set = set2;
        }
        printWriter.println("\t[CIRCULAR REFERENCE:" + th + C3040d4.i.e);
    }

    /* compiled from: Stack.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f301a;
        public int b;

        public a(int i, int i2) {
            this.f301a = i;
            this.b = i2;
        }

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.f301a);
                jSONObject.put("end", this.b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    private static boolean a(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (aVar.f301a == -1) {
                if (a(stackTraceElementArr[i].getClassName(), strArr)) {
                    aVar.f301a = i;
                    aVar.b = i;
                }
            } else if (!a(stackTraceElementArr[i].getClassName(), strArr)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f301a != -1) {
            aVar.b = stackTraceElementArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static JSONArray a(String[] strArr, String[] strArr2) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (aVar.f301a == -1) {
                if (a(strArr[i], strArr2)) {
                    aVar.f301a = i;
                    aVar.b = i;
                }
            } else if (!a(strArr[i], strArr2)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f301a != -1) {
            aVar.b = strArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static void a(Throwable th, int i) {
        if (th == null || i <= 0) {
            return;
        }
        try {
            b(th, i);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                a(stackTraceElement, i);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i, "Suppressed: ", "\t");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, i, "Caused by: ", "");
            }
        } catch (Throwable unused) {
        }
    }
}
