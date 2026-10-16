package com.bykv.vk.openvk.preload.a;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes3.dex */
public abstract class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f854a = new b("IDENTITY") { // from class: com.bykv.vk.openvk.preload.a.b.1
        {
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return field.getName();
        }
    };
    private static b b = new b("UPPER_CAMEL_CASE") { // from class: com.bykv.vk.openvk.preload.a.b.2
        {
            int i = 1;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return a(field.getName());
        }
    };
    private static b c = new b("UPPER_CAMEL_CASE_WITH_SPACES") { // from class: com.bykv.vk.openvk.preload.a.b.3
        {
            int i = 2;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return a(a(field.getName(), " "));
        }
    };
    private static b d = new b("LOWER_CASE_WITH_UNDERSCORES") { // from class: com.bykv.vk.openvk.preload.a.b.4
        {
            int i = 3;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    };
    private static b e = new b("LOWER_CASE_WITH_DASHES") { // from class: com.bykv.vk.openvk.preload.a.b.5
        {
            int i = 4;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };
    private static b f = new b("LOWER_CASE_WITH_DOTS") { // from class: com.bykv.vk.openvk.preload.a.b.6
        {
            int i = 5;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    private b(String str, int i) {
    }

    /* synthetic */ b(String str, int i, byte b2) {
        this(str, i);
    }

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String a(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char charAt = str.charAt(i);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }
}
