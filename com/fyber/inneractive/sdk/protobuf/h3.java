package com.fyber.inneractive.sdk.protobuf;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public abstract class h3 {
    public static String a(s sVar) {
        StringBuilder sb = new StringBuilder(sVar.size());
        for (int i = 0; i < sVar.size(); i++) {
            byte c = sVar.c(i);
            if (c == 34) {
                sb.append("\\\"");
            } else if (c == 39) {
                sb.append("\\'");
            } else if (c != 92) {
                switch (c) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (c < 32 || c > 126) {
                            sb.append(AbstractJsonLexerKt.STRING_ESC);
                            sb.append((char) (((c >>> 6) & 3) + 48));
                            sb.append((char) (((c >>> 3) & 7) + 48));
                            sb.append((char) ((c & 7) + 48));
                            break;
                        } else {
                            sb.append((char) c);
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
