package com.fyber.inneractive.sdk.protobuf;

import com.ironsource.C3040d4;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public abstract class f2 {
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b4, code lost:
    
        if (((java.lang.Integer) r4).intValue() == 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x020b, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c5, code lost:
    
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d7, code lost:
    
        if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(d2 d2Var, StringBuilder sb, int i) {
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : d2Var.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String substring = str.startsWith("get") ? str.substring(3) : str;
            boolean z = true;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String str2 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 4);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i, a(str2), z0.invokeOrDie(method2, d2Var, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String str3 = substring.substring(0, 1).toLowerCase() + substring.substring(1, substring.length() - 3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i, a(str3), z0.invokeOrDie(method3, d2Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(substring))) != null && (!substring.endsWith("Bytes") || !hashMap.containsKey("get" + substring.substring(0, substring.length() - 5)))) {
                String str4 = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                Method method4 = (Method) hashMap.get("get".concat(substring));
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object invokeOrDie = z0.invokeOrDie(method4, d2Var, new Object[0]);
                    if (method5 == null) {
                        if (invokeOrDie instanceof Boolean) {
                            equals = !((Boolean) invokeOrDie).booleanValue();
                        } else if (!(invokeOrDie instanceof Integer)) {
                            if (!(invokeOrDie instanceof Float)) {
                                if (!(invokeOrDie instanceof Double)) {
                                    equals = invokeOrDie instanceof String ? invokeOrDie.equals("") : invokeOrDie instanceof s ? invokeOrDie.equals(s.b) : !(invokeOrDie instanceof d2) ? false : false;
                                }
                            }
                        }
                        if (equals) {
                            z = false;
                        }
                    } else {
                        z = ((Boolean) z0.invokeOrDie(method5, d2Var, new Object[0])).booleanValue();
                    }
                    if (z) {
                        a(sb, i, a(str4), invokeOrDie);
                    }
                }
            }
        }
        if (d2Var instanceof GeneratedMessageLite$ExtendableMessage) {
            Iterator d = ((GeneratedMessageLite$ExtendableMessage) d2Var).extensions.d();
            while (d.hasNext()) {
                Map.Entry entry = (Map.Entry) d.next();
                a(sb, i, C3040d4.i.d + ((w0) entry.getKey()).b + C3040d4.i.e, entry.getValue());
            }
        }
        n3 n3Var = ((z0) d2Var).unknownFields;
        if (n3Var != null) {
            for (int i2 = 0; i2 < n3Var.f1689a; i2++) {
                a(sb, i, String.valueOf(n3Var.b[i2] >>> 3), n3Var.c[i2]);
            }
        }
    }

    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(h3.a(s.a((String) obj))).append('\"');
            return;
        }
        if (obj instanceof s) {
            sb.append(": \"").append(h3.a((s) obj)).append('\"');
            return;
        }
        if (obj instanceof z0) {
            sb.append(" {");
            a((z0) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i4 = i + 2;
            a(sb, i4, C3040d4.h.W, entry.getKey());
            a(sb, i4, "value", entry.getValue());
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ").append(obj.toString());
    }

    public static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
