package com.bytedance.sdk.component.DbA.eli;

import com.google.common.base.Ascii;
import com.ironsource.D5;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public final class kb {
    private static final char[] aGH = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String DbA;
    private final String FC;
    private final String MGA;
    final int Os;
    private final String aAs;
    final String eli;
    private final List<String> kb;
    private final String ui;
    private final List<String> wC;

    kb(eli eliVar) {
        this.eli = eliVar.eli;
        this.ui = eli(eliVar.DbA, false);
        this.MGA = eli(eliVar.Os, false);
        this.DbA = eliVar.aGH;
        this.Os = eliVar.eli();
        this.kb = eli(eliVar.MGA, false);
        this.wC = eliVar.kb != null ? eli(eliVar.kb, true) : null;
        this.FC = eliVar.wC != null ? eli(eliVar.wC, false) : null;
        this.aAs = eliVar.toString();
    }

    public URL eli() {
        try {
            return new URL(this.aAs);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String DbA() {
        if (this.ui.isEmpty()) {
            return "";
        }
        int length = this.eli.length() + 3;
        String str = this.aAs;
        return this.aAs.substring(length, com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str, length, str.length(), ":@"));
    }

    public String Os() {
        if (this.MGA.isEmpty()) {
            return "";
        }
        return this.aAs.substring(this.aAs.indexOf(58, this.eli.length() + 3) + 1, this.aAs.indexOf(64));
    }

    public static int eli(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void eli(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> aGH() {
        int indexOf = this.aAs.indexOf(47, this.eli.length() + 3);
        String str = this.aAs;
        int eli2 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < eli2) {
            int i = indexOf + 1;
            int eli3 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(this.aAs, i, eli2, '/');
            arrayList.add(this.aAs.substring(i, eli3));
            indexOf = eli3;
        }
        return arrayList;
    }

    public String ui() {
        if (this.wC == null) {
            return null;
        }
        int indexOf = this.aAs.indexOf(63) + 1;
        String str = this.aAs;
        return this.aAs.substring(indexOf, com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str, indexOf, str.length(), '#'));
    }

    static void DbA(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(D5.T);
                sb.append(str2);
            }
        }
    }

    static List<String> DbA(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public static kb Os(String str) {
        eli eliVar = new eli();
        if (eliVar.eli((kb) null, str) == eli.EnumC0131eli.SUCCESS) {
            return eliVar.DbA();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof kb) && ((kb) obj).aAs.equals(this.aAs);
    }

    public int hashCode() {
        return this.aAs.hashCode();
    }

    public String toString() {
        return this.aAs;
    }

    public static final class eli {
        final List<String> MGA;
        String aGH;
        String eli;
        List<String> kb;
        String wC;
        String DbA = "";
        String Os = "";
        int ui = -1;

        /* renamed from: com.bytedance.sdk.component.DbA.eli.kb$eli$eli, reason: collision with other inner class name */
        enum EnumC0131eli {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public eli() {
            ArrayList arrayList = new ArrayList();
            this.MGA = arrayList;
            arrayList.add("");
        }

        public eli eli(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.eli = "http";
                return this;
            }
            if (str.equalsIgnoreCase("https")) {
                this.eli = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str)));
        }

        public eli DbA(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String ui = ui(str, 0, str.length());
            if (ui == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(str)));
            }
            this.aGH = ui;
            return this;
        }

        int eli() {
            int i = this.ui;
            return i != -1 ? i : kb.eli(this.eli);
        }

        public eli Os(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegments == null");
            }
            return eli(str, true);
        }

        private eli eli(String str, boolean z) {
            boolean z2;
            eli eliVar;
            String str2;
            boolean z3;
            int i = 0;
            while (true) {
                int eli = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str, i, str.length(), "/\\");
                if (eli < str.length()) {
                    z2 = true;
                    str2 = str;
                    z3 = z;
                    eliVar = this;
                } else {
                    z2 = false;
                    eliVar = this;
                    str2 = str;
                    z3 = z;
                }
                eliVar.eli(str2, i, eli, z2, z3);
                i = eli + 1;
                if (i > str2.length()) {
                    return eliVar;
                }
                str = str2;
                z = z3;
            }
        }

        public eli aGH(String str) {
            this.kb = str != null ? kb.DbA(kb.eli(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public eli eli(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.kb == null) {
                this.kb = new ArrayList();
            }
            this.kb.add(kb.eli(str, " \"'<>#&=", true, false, true, true));
            this.kb.add(str2 != null ? kb.eli(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public kb DbA() {
            if (this.eli == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.aGH == null) {
                throw new IllegalStateException("host == null");
            }
            return new kb(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.eli);
            sb.append("://");
            if (!this.DbA.isEmpty() || !this.Os.isEmpty()) {
                sb.append(this.DbA);
                if (!this.Os.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.Os);
                }
                sb.append('@');
            }
            if (this.aGH.indexOf(58) != -1) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(this.aGH);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(this.aGH);
            }
            int eli = eli();
            if (eli != kb.eli(this.eli)) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(eli);
            }
            kb.eli(sb, this.MGA);
            if (this.kb != null) {
                sb.append('?');
                kb.DbA(sb, this.kb);
            }
            if (this.wC != null) {
                sb.append('#');
                sb.append(this.wC);
            }
            return sb.toString();
        }

        EnumC0131eli eli(kb kbVar, String str) {
            int eli;
            String str2;
            int i;
            String str3;
            String str4 = str;
            int eli2 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str4, 0, str4.length());
            int DbA = com.bytedance.sdk.component.DbA.eli.DbA.FC.DbA(str4, eli2, str4.length());
            if (DbA(str4, eli2, DbA) != -1) {
                if (str4.regionMatches(true, eli2, "https:", 0, 6)) {
                    this.eli = "https";
                    eli2 += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (str4.regionMatches(true, eli2, "http:", 0, 5)) {
                        this.eli = "http";
                        eli2 += 5;
                    } else {
                        return EnumC0131eli.UNSUPPORTED_SCHEME;
                    }
                }
            } else if (kbVar != null) {
                this.eli = kbVar.eli;
            } else {
                return EnumC0131eli.MISSING_SCHEME;
            }
            int Os = Os(str4, eli2, DbA);
            char c = '#';
            if (Os >= 2 || kbVar == null || !kbVar.eli.equals(this.eli)) {
                int i2 = eli2 + Os;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    eli = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str4, i2, DbA, "@/\\?#");
                    char charAt = eli != DbA ? str4.charAt(eli) : (char) 65535;
                    if (charAt == 65535 || charAt == c || charAt == '/' || charAt == '\\' || charAt == '?') {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = eli;
                            str3 = str;
                            this.Os += "%40" + kb.eli(str3, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int eli3 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str4, i2, eli, AbstractJsonLexerKt.COLON);
                            String eli4 = kb.eli(str, i2, eli3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                eli4 = this.DbA + "%40" + eli4;
                            }
                            this.DbA = eli4;
                            if (eli3 != eli) {
                                i = eli;
                                this.Os = kb.eli(str, eli3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            } else {
                                i = eli;
                            }
                            str3 = str;
                            z2 = true;
                        }
                        i2 = i + 1;
                        str4 = str3;
                        c = '#';
                    }
                }
                str2 = str4;
                int i3 = i2;
                int aGH = aGH(str2, i3, eli);
                int i4 = aGH + 1;
                if (i4 < eli) {
                    this.aGH = ui(str2, i3, aGH);
                    int MGA = MGA(str2, i4, eli);
                    this.ui = MGA;
                    if (MGA == -1) {
                        return EnumC0131eli.INVALID_PORT;
                    }
                } else {
                    this.aGH = ui(str2, i3, aGH);
                    this.ui = kb.eli(this.eli);
                }
                if (this.aGH == null) {
                    return EnumC0131eli.INVALID_HOST;
                }
                eli2 = eli;
            } else {
                this.DbA = kbVar.DbA();
                this.Os = kbVar.Os();
                this.aGH = kbVar.DbA;
                this.ui = kbVar.Os;
                this.MGA.clear();
                this.MGA.addAll(kbVar.aGH());
                if (eli2 == DbA || str4.charAt(eli2) == '#') {
                    aGH(kbVar.ui());
                }
                str2 = str4;
            }
            int eli5 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str2, eli2, DbA, "?#");
            eli(str2, eli2, eli5);
            if (eli5 < DbA && str2.charAt(eli5) == '?') {
                int eli6 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str2, eli5, DbA, '#');
                this.kb = kb.DbA(kb.eli(str2, eli5 + 1, eli6, " \"'<>#", true, false, true, true, null));
                eli5 = eli6;
            }
            if (eli5 < DbA && str2.charAt(eli5) == '#') {
                this.wC = kb.eli(str2, eli5 + 1, DbA, "", true, false, false, false, null);
            }
            return EnumC0131eli.SUCCESS;
        }

        private void eli(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.MGA.clear();
                this.MGA.add("");
                i++;
            } else {
                List<String> list = this.MGA;
                list.set(list.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int eli = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str, i3, i2, "/\\");
                boolean z = eli < i2;
                String str2 = str;
                eli(str2, i3, eli, z, true);
                if (z) {
                    eli++;
                }
                i3 = eli;
                str = str2;
            }
        }

        private void eli(String str, int i, int i2, boolean z, boolean z2) {
            String eli = kb.eli(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (ui(eli)) {
                return;
            }
            if (MGA(eli)) {
                Os();
                return;
            }
            if (this.MGA.get(r11.size() - 1).isEmpty()) {
                this.MGA.set(r11.size() - 1, eli);
            } else {
                this.MGA.add(eli);
            }
            if (z) {
                this.MGA.add("");
            }
        }

        private boolean ui(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean MGA(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void Os() {
            if (this.MGA.remove(r0.size() - 1).isEmpty() && !this.MGA.isEmpty()) {
                this.MGA.set(r0.size() - 1, "");
            } else {
                this.MGA.add("");
            }
        }

        private static int DbA(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int Os(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int aGH(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String ui(String str, int i, int i2) {
            return com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(kb.eli(str, i, i2, false));
        }

        private static int MGA(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(kb.eli(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }
    }

    static String eli(String str, boolean z) {
        return eli(str, 0, str.length(), z);
    }

    private List<String> eli(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? eli(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String eli(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.bytedance.sdk.component.DbA.eli.DbA.eli eliVar = new com.bytedance.sdk.component.DbA.eli.DbA.eli();
                eliVar.eli(str, i, i3);
                eli(eliVar, str, i3, i2, z);
                return eliVar.Os();
            }
        }
        return str.substring(i, i2);
    }

    static void eli(com.bytedance.sdk.component.DbA.eli.DbA.eli eliVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int eli2 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str.charAt(i + 1));
                int eli3 = com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str.charAt(i3));
                if (eli2 != -1 && eli3 != -1) {
                    eliVar.DbA((eli2 << 4) + eli3);
                    i = i3;
                }
                eliVar.eli(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    eliVar.DbA(32);
                }
                eliVar.eli(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static boolean eli(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.DbA.eli.DbA.FC.eli(str.charAt(i3)) != -1;
    }

    static String eli(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || eli(str, i3, i2)))) && (codePointAt != 43 || !z3)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                com.bytedance.sdk.component.DbA.eli.DbA.eli eliVar = new com.bytedance.sdk.component.DbA.eli.DbA.eli();
                eliVar.eli(str, i, i3);
                eli(eliVar, str, i3, i2, str2, z, z2, z3, z4, charset);
                return eliVar.Os();
            }
        }
        return str.substring(i, i2);
    }

    static void eli(com.bytedance.sdk.component.DbA.eli.DbA.eli eliVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.DbA.eli.DbA.eli eliVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    eliVar.eli(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !eli(str, i, i2)))))) {
                    if (eliVar2 == null) {
                        eliVar2 = new com.bytedance.sdk.component.DbA.eli.DbA.eli();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.DbA.eli.DbA.FC.eli)) {
                        eliVar2.eli(codePointAt);
                    } else {
                        eliVar2.eli(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!eliVar2.eli()) {
                        byte DbA = eliVar2.DbA();
                        eliVar.DbA(37);
                        char[] cArr = aGH;
                        eliVar.DbA((int) cArr[((DbA & 255) >> 4) & 15]);
                        eliVar.DbA((int) cArr[DbA & Ascii.SI]);
                    }
                } else {
                    eliVar.eli(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String eli(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return eli(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
