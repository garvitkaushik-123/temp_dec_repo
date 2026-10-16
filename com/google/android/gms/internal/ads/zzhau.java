package com.google.android.gms.internal.ads;

import com.ironsource.C3040d4;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhau {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzhas zzhasVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzhasVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzhbv.zza(zzgxz.zzw((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzgxz) {
            sb.append(": \"");
            sb.append(zzhbv.zza((zzgxz) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzgzh) {
            sb.append(" {");
            zzd((zzgzh) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i3, C3040d4.h.W, entry.getKey());
        zzb(sb, i3, "value", entry.getValue());
        sb.append("\n");
        zzc(i, sb);
        sb.append("}");
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzhas zzhasVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzhasVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzgzh.zzbP(method2, zzhasVar, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, substring.substring(0, substring.length() - 3), zzgzh.zzbP(method, zzhasVar, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzbP = zzgzh.zzbP(method4, zzhasVar, new Object[0]);
                    if (method5 != null) {
                        if (!((Boolean) zzgzh.zzbP(method5, zzhasVar, new Object[0])).booleanValue()) {
                        }
                        zzb(sb, i, substring, zzbP);
                    } else if (zzbP instanceof Boolean) {
                        if (!((Boolean) zzbP).booleanValue()) {
                        }
                        zzb(sb, i, substring, zzbP);
                    } else if (zzbP instanceof Integer) {
                        if (((Integer) zzbP).intValue() == 0) {
                        }
                        zzb(sb, i, substring, zzbP);
                    } else if (zzbP instanceof Float) {
                        if (Float.floatToRawIntBits(((Float) zzbP).floatValue()) == 0) {
                        }
                        zzb(sb, i, substring, zzbP);
                    } else if (zzbP instanceof Double) {
                        if (Double.doubleToRawLongBits(((Double) zzbP).doubleValue()) == 0) {
                        }
                        zzb(sb, i, substring, zzbP);
                    } else {
                        if (zzbP instanceof String) {
                            equals = zzbP.equals("");
                        } else if (zzbP instanceof zzgxz) {
                            equals = zzbP.equals(zzgxz.zzb);
                        } else if (zzbP instanceof zzhas) {
                            if (zzbP == ((zzhas) zzbP).zzbt()) {
                            }
                            zzb(sb, i, substring, zzbP);
                        } else {
                            if ((zzbP instanceof Enum) && ((Enum) zzbP).ordinal() == 0) {
                            }
                            zzb(sb, i, substring, zzbP);
                        }
                        if (equals) {
                        }
                        zzb(sb, i, substring, zzbP);
                    }
                }
            }
            i2 = 3;
        }
        if (zzhasVar instanceof zzgzd) {
            Iterator zzf = ((zzgzd) zzhasVar).zza.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                zzb(sb, i, C3040d4.i.d + ((zzgze) entry2.getKey()).zza + C3040d4.i.e, entry2.getValue());
            }
        }
        zzhby zzhbyVar = ((zzgzh) zzhasVar).zzt;
        if (zzhbyVar != null) {
            zzhbyVar.zzi(sb, i);
        }
    }
}
