package com.bykv.vk.openvk.preload.a.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: ISO8601Utils.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f858a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4 A[Catch: IllegalArgumentException -> 0x01ba, IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, IndexOutOfBoundsException -> 0x01be, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:18:0x0051, B:20:0x0061, B:21:0x0063, B:23:0x006f, B:24:0x0072, B:26:0x0078, B:30:0x0082, B:35:0x0092, B:37:0x009a, B:42:0x00ce, B:44:0x00d4, B:46:0x00da, B:47:0x0181, B:52:0x00e4, B:53:0x00fe, B:54:0x00ff, B:57:0x011d, B:59:0x012a, B:62:0x0133, B:64:0x014b, B:67:0x015a, B:68:0x017c, B:70:0x017f, B:71:0x010a, B:72:0x01b2, B:73:0x01b9, B:74:0x00b2, B:75:0x00b5), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b2 A[Catch: IllegalArgumentException -> 0x01ba, IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, IndexOutOfBoundsException -> 0x01be, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:18:0x0051, B:20:0x0061, B:21:0x0063, B:23:0x006f, B:24:0x0072, B:26:0x0078, B:30:0x0082, B:35:0x0092, B:37:0x009a, B:42:0x00ce, B:44:0x00d4, B:46:0x00da, B:47:0x0181, B:52:0x00e4, B:53:0x00fe, B:54:0x00ff, B:57:0x011d, B:59:0x012a, B:62:0x0133, B:64:0x014b, B:67:0x015a, B:68:0x017c, B:70:0x017f, B:71:0x010a, B:72:0x01b2, B:73:0x01b9, B:74:0x00b2, B:75:0x00b5), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        int i;
        int i2;
        int i3;
        int i4;
        int length;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int a2 = a(str, index, i5);
            if (a(str, i5, '-')) {
                i5 = index + 5;
            }
            int i6 = i5 + 2;
            int a3 = a(str, i5, i6);
            if (a(str, i6, '-')) {
                i6 = i5 + 3;
            }
            int i7 = i6 + 2;
            int a4 = a(str, i6, i7);
            boolean a5 = a(str, i7, 'T');
            if (!a5 && str.length() <= i7) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(a2, a3 - 1, a4);
                parsePosition.setIndex(i7);
                return gregorianCalendar.getTime();
            }
            if (a5) {
                int i8 = i6 + 5;
                int a6 = a(str, i6 + 3, i8);
                if (a(str, i8, AbstractJsonLexerKt.COLON)) {
                    i8 = i6 + 6;
                }
                int i9 = i8 + 2;
                int a7 = a(str, i8, i9);
                if (a(str, i9, AbstractJsonLexerKt.COLON)) {
                    i9 = i8 + 3;
                }
                if (str.length() > i9 && (charAt = str.charAt(i9)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i10 = i9 + 2;
                    i4 = a(str, i9, i10);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (a(str, i10, '.')) {
                        int i11 = i9 + 3;
                        int a8 = a(str, i9 + 4);
                        int min = Math.min(a8, i9 + 6);
                        int a9 = a(str, i11, min);
                        int i12 = min - i11;
                        if (i12 == 1) {
                            a9 *= 100;
                        } else if (i12 == 2) {
                            a9 *= 10;
                        }
                        i = a6;
                        i7 = a8;
                        i2 = a7;
                        i3 = a9;
                    } else {
                        i = a6;
                        i7 = i10;
                        i2 = a7;
                        i3 = 0;
                    }
                    if (str.length() > i7) {
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                    char charAt2 = str.charAt(i7);
                    if (charAt2 == 'Z') {
                        timeZone = f858a;
                        length = i7 + 1;
                    } else {
                        if (charAt2 != '+' && charAt2 != '-') {
                            throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                        }
                        String substring = str.substring(i7);
                        if (substring.length() < 5) {
                            substring = substring + "00";
                        }
                        length = i7 + substring.length();
                        if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                            String concat = "GMT".concat(String.valueOf(substring));
                            TimeZone timeZone2 = TimeZone.getTimeZone(concat);
                            String id = timeZone2.getID();
                            if (!id.equals(concat) && !id.replace(":", "").equals(concat)) {
                                throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + concat + " given, resolves to " + timeZone2.getID());
                            }
                            timeZone = timeZone2;
                        }
                        timeZone = f858a;
                    }
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                    gregorianCalendar2.setLenient(false);
                    gregorianCalendar2.set(1, a2);
                    gregorianCalendar2.set(2, a3 - 1);
                    gregorianCalendar2.set(5, a4);
                    gregorianCalendar2.set(11, i);
                    gregorianCalendar2.set(12, i2);
                    gregorianCalendar2.set(13, i4);
                    gregorianCalendar2.set(14, i3);
                    parsePosition.setIndex(length);
                    return gregorianCalendar2.getTime();
                }
                i7 = i9;
                i = a6;
                i2 = a7;
            } else {
                i = 0;
                i2 = 0;
            }
            i3 = 0;
            i4 = 0;
            if (str.length() > i7) {
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e) {
            String str2 = str == null ? null : "\"" + str + '\"';
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
