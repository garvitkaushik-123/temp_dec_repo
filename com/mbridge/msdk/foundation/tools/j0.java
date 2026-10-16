package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: SameBase64Tool.java */
/* loaded from: classes6.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Character, Character> f4370a;
    private static Map<Character, Character> b;
    private static byte[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    private static char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', GMTDateParser.YEAR, 'Z', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    static {
        HashMap hashMap = new HashMap();
        f4370a = hashMap;
        hashMap.put('v', 'A');
        f4370a.put('S', 'B');
        f4370a.put('o', 'C');
        f4370a.put('a', 'D');
        f4370a.put('j', 'E');
        f4370a.put('c', 'F');
        f4370a.put('7', 'G');
        f4370a.put(Character.valueOf(GMTDateParser.DAY_OF_MONTH), 'H');
        f4370a.put('R', 'I');
        f4370a.put(Character.valueOf(GMTDateParser.ZONE), 'J');
        f4370a.put('p', 'K');
        f4370a.put('W', 'L');
        f4370a.put('i', Character.valueOf(GMTDateParser.MONTH));
        f4370a.put('f', 'N');
        f4370a.put('G', 'O');
        f4370a.put('y', 'P');
        f4370a.put('N', 'Q');
        f4370a.put('x', 'R');
        f4370a.put('Z', 'S');
        f4370a.put('n', 'T');
        f4370a.put('V', 'U');
        f4370a.put('5', 'V');
        f4370a.put('k', 'W');
        f4370a.put('+', 'X');
        f4370a.put('D', Character.valueOf(GMTDateParser.YEAR));
        f4370a.put('H', 'Z');
        f4370a.put('L', 'a');
        f4370a.put(Character.valueOf(GMTDateParser.YEAR), 'b');
        f4370a.put(Character.valueOf(GMTDateParser.HOURS), 'c');
        f4370a.put('J', Character.valueOf(GMTDateParser.DAY_OF_MONTH));
        f4370a.put('4', 'e');
        f4370a.put('6', 'f');
        f4370a.put('l', 'g');
        f4370a.put('t', Character.valueOf(GMTDateParser.HOURS));
        f4370a.put('0', 'i');
        f4370a.put('U', 'j');
        f4370a.put('3', 'k');
        f4370a.put('Q', 'l');
        f4370a.put('r', Character.valueOf(GMTDateParser.MINUTES));
        f4370a.put('g', 'n');
        f4370a.put('E', 'o');
        f4370a.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), 'p');
        f4370a.put('q', 'q');
        f4370a.put('8', 'r');
        f4370a.put(Character.valueOf(GMTDateParser.SECONDS), Character.valueOf(GMTDateParser.SECONDS));
        f4370a.put('w', 't');
        f4370a.put('/', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC));
        f4370a.put('X', 'v');
        f4370a.put(Character.valueOf(GMTDateParser.MONTH), 'w');
        f4370a.put('e', 'x');
        f4370a.put('B', 'y');
        f4370a.put('A', Character.valueOf(GMTDateParser.ZONE));
        f4370a.put('T', '0');
        f4370a.put('2', '1');
        f4370a.put('F', '2');
        f4370a.put('b', '3');
        f4370a.put('9', '4');
        f4370a.put('P', '5');
        f4370a.put('1', '6');
        f4370a.put('O', '7');
        f4370a.put('I', '8');
        f4370a.put('K', '9');
        f4370a.put(Character.valueOf(GMTDateParser.MINUTES), '+');
        f4370a.put('C', '/');
        HashMap hashMap2 = new HashMap();
        b = hashMap2;
        hashMap2.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', Character.valueOf(GMTDateParser.DAY_OF_MONTH));
        b.put('I', 'R');
        b.put('J', Character.valueOf(GMTDateParser.ZONE));
        b.put('K', 'p');
        b.put('L', 'W');
        b.put(Character.valueOf(GMTDateParser.MONTH), 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put(Character.valueOf(GMTDateParser.YEAR), 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put('b', Character.valueOf(GMTDateParser.YEAR));
        b.put('c', Character.valueOf(GMTDateParser.HOURS));
        b.put(Character.valueOf(GMTDateParser.DAY_OF_MONTH), 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', 'l');
        b.put(Character.valueOf(GMTDateParser.HOURS), 't');
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put('l', 'Q');
        b.put(Character.valueOf(GMTDateParser.MINUTES), 'r');
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC));
        b.put('q', 'q');
        b.put('r', '8');
        b.put(Character.valueOf(GMTDateParser.SECONDS), Character.valueOf(GMTDateParser.SECONDS));
        b.put('t', 'w');
        b.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), '/');
        b.put('v', 'X');
        b.put('w', Character.valueOf(GMTDateParser.MONTH));
        b.put('x', 'e');
        b.put('y', 'B');
        b.put(Character.valueOf(GMTDateParser.ZONE), 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', 'b');
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', Character.valueOf(GMTDateParser.MINUTES));
        b.put('/', 'C');
    }

    public static String a(String str) {
        return q0.b(str);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : q0.c(str);
    }
}
