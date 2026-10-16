package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.base.ElementTypesAreNonnullByDefault;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.kl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2162kl {
    public static byte[] A00;

    static {
        A05();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> InterfaceC2160kj<T> A00(InterfaceC2160kj<? super T> first, InterfaceC2160kj<? super T> second) {
        return new C9(A04((InterfaceC2160kj) AbstractC2159ki.A04(first), (InterfaceC2160kj) AbstractC2159ki.A04(second)));
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 111);
        }
        return new String(copyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static String A02(String methodName, Iterable<?> components) {
        StringBuilder append = new StringBuilder(A01(0, 11, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE)).append(methodName).append('(');
        boolean z = true;
        for (Object obj : components) {
            if (!z) {
                append.append(AbstractJsonLexerKt.COMMA);
            }
            append.append(obj);
            z = false;
        }
        return append.append(')').toString();
    }

    public static void A05() {
        A00 = new byte[]{59, 93, 80, 79, 84, 78, 76, 95, 80, 94, Ascii.EM};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    public static <T> List<InterfaceC2160kj<? super T>> A04(InterfaceC2160kj<? super T> first, InterfaceC2160kj<? super T> second) {
        return Arrays.asList(first, second);
    }
}
