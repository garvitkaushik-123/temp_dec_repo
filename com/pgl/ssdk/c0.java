package com.pgl.ssdk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final FileFilter f6379a = new a();

    static class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x001c, code lost:
    
        if (r1 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str2 = null;
        try {
            fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            fileReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
            }
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return str2 == null ? "0" : str2.trim();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0046, code lost:
    
        if (r2 != null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HashMap<String, String> b() {
        FileReader fileReader;
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] split = readLine.split(":", 2);
                            if (split.length >= 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                if (hashMap.get(trim) == null) {
                                    hashMap.put(trim, trim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return hashMap;
    }

    public static String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> b = b();
            jSONObject.put("core", a());
            jSONObject.put("hw", a(b, "Hardware"));
            jSONObject.put("max", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            jSONObject.put("min", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            jSONObject.put("ft", a(b, "Features"));
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        return jSONObject2 == null ? "{}" : jSONObject2.trim();
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        String str2;
        try {
            str2 = hashMap.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }

    private static int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f6379a).length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
