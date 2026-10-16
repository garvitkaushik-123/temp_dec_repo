package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* renamed from: com.facebook.ads.redexgen.X.ks, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2169ks implements LR {
    public static byte[] A09;
    public static String[] A0A = {"jhQijRHeS2b3DC", "TrxlLGPRt74PJqIyPQ202SRMEezA", "IB0ZY9fOXgD7jLe6Y4PRk3dCNjPCK6", "H6fabJXG57DAkPtsQTSNUghzavXSaH69", "ufMT47zQTczJDi2Vdc2LdI1YLyWR3nOe", "Lk9ILhYpp3cxsVDBevZ7UGW4HuH86l", "wl", "vesbJwqYWy5viKlOFyHJIQca6g"};
    public static final String A0B;
    public final int A00;
    public final int A01;
    public final LZ A02;
    public final InterfaceC1148Lm A04;
    public final T8 A05;
    public final boolean A08;
    public final Map<String, File> A06 = Collections.synchronizedMap(new HashMap());
    public final Map<String, Semaphore> A07 = new HashMap();
    public final C1137Lb A03 = new C1137Lb();

    /* JADX WARN: Failed to calculate best type for var: r10v0 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyInvokeTypes(TypeUpdate.java:390)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.invokeListener(TypeUpdate.java:355)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:156)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:133)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:238)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
     */
    /* JADX WARN: Failed to calculate best type for var: r10v0 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyInvokeTypes(TypeUpdate.java:390)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.invokeListener(TypeUpdate.java:355)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /* JADX WARN: Failed to calculate best type for var: r10v1 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyInvokeTypes(TypeUpdate.java:390)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.invokeListener(TypeUpdate.java:355)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:156)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:133)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:238)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
     */
    /* JADX WARN: Failed to calculate best type for var: r10v1 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyInvokeTypes(TypeUpdate.java:390)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.invokeListener(TypeUpdate.java:355)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /* JADX WARN: Failed to calculate best type for var: r5v0 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:156)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:133)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:238)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
     */
    /* JADX WARN: Failed to calculate best type for var: r5v0 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /* JADX WARN: Failed to calculate best type for var: r5v1 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:156)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:133)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:238)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
     */
    /* JADX WARN: Failed to calculate best type for var: r5v1 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 23 out of bounds for length 23
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Multi-variable type inference failed. Error: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyInvokeTypes(TypeUpdate.java:390)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.invokeListener(TypeUpdate.java:355)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:188)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:70)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:116)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0126: INVOKE 
      (r10v1 ?? I:com.facebook.ads.redexgen.X.Lm)
      (r11 I:java.lang.String)
      (r12 I:int)
      (r13 I:java.lang.String)
      (r14 I:java.lang.Long)
      (r15 I:java.lang.Long)
      (r16 I:com.facebook.ads.redexgen.X.LX)
     INTERFACE call: com.facebook.ads.redexgen.X.Lm.AHU(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.LX):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.LX):void (m)], block:B:54:0x011a */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0141: INVOKE 
      (r10v0 ?? I:com.facebook.ads.redexgen.X.Lm)
      (r11 I:java.lang.String)
      (r12 I:int)
      (r13 I:java.lang.String)
      (r14 I:java.lang.Long)
      (r15 I:java.lang.Long)
      (r16 I:com.facebook.ads.redexgen.X.LX)
     INTERFACE call: com.facebook.ads.redexgen.X.Lm.AHU(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.LX):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.LX):void (m)], block:B:60:0x0135 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0124: MOVE (r16 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:54:0x011a */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x013f: MOVE (r16 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:60:0x0135 */
    private File A02(LX lx, String str, String str2, int i, C1136La c1136La) {
        LX lx2;
        String AHU;
        LX lx3;
        String AHU2;
        String A03 = A03(Sdk.SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, 22, 17);
        try {
            String str3 = str;
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(A01(this.A05), str2);
            final long A0R = C1379Up.A0R(this.A05);
            C2163km c2163km = new C2163km(file, new AbstractC2168kr(A0R) { // from class: com.facebook.ads.redexgen.X.8L
                public static byte[] A01;
                public final long A00;

                static {
                    A01();
                }

                public static String A00(int i2, int i3, int i4) {
                    byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
                    for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                        copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 38);
                    }
                    return new String(copyOfRange);
                }

                public static void A01() {
                    A01 = new byte[]{-31, -11, Ascii.FF, -76, 7, -3, Ascii.SO, -7, -76, 1, 9, 7, 8, -76, -10, -7, -76, 4, 3, 7, -3, 8, -3, 10, -7, -76, 2, 9, 1, -10, -7, 6, -75};
                }

                {
                    if (A0R > 0) {
                        this.A00 = A0R;
                        return;
                    }
                    throw new IllegalArgumentException(A00(0, 33, 110));
                }

                @Override // com.instagram.common.viewpoint.core.AbstractC2168kr
                public final boolean A08(File file2, long j, int i2) {
                    return j <= this.A00;
                }

                @Override // com.instagram.common.viewpoint.core.AbstractC2168kr, com.instagram.common.viewpoint.core.InterfaceC1138Lc
                public final /* bridge */ /* synthetic */ void AKR(File file2) throws IOException {
                    super.AKR(file2);
                }
            });
            if (c2163km.A09()) {
                if (this.A08) {
                    String str4 = A03(49, 22, 36) + c2163km.A00.getName();
                }
                this.A06.put(str3, file);
                c2163km.A06();
                this.A04.AHV(str3, true, lx);
                return file;
            }
            if (this.A08) {
                String str5 = A03(71, 26, 76) + c2163km.A00.getName();
            }
            if (!c1136La.A04()) {
                return null;
            }
            this.A04.AHV(str3, false, lx);
            for (int i2 = 0; i2 < this.A00; i2++) {
                try {
                    T8 t8 = this.A05;
                    if (A0A[3].charAt(31) != '9') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0A;
                    strArr[2] = "QJ6lhIf3SMnJsUHWjUzyv1yZJIRdgp";
                    strArr[5] = "f1TQksdEGnGezGtACwRIsNgGsb1lS2";
                    str3 = str3;
                    try {
                        A05(t8, c2163km, str3, i, i2, currentTimeMillis);
                        break;
                    } catch (C1144Li e) {
                        e = e;
                        if (i2 == this.A00 - 1) {
                            A06(c2163km);
                            if (e instanceof C2164kn) {
                                throw ((C2164kn) e);
                            }
                            if (e instanceof C2157kg) {
                                throw ((C2157kg) e);
                            }
                        }
                    }
                } catch (C1144Li e2) {
                    e = e2;
                }
            }
            int A032 = c2163km.A03();
            c2163km.A06();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            c1136La.A00().A5D(file, this.A04);
            this.A06.put(str3, file);
            this.A04.AHU(str3, 2112, null, Long.valueOf(A032), Long.valueOf(currentTimeMillis2), lx);
            return file;
        } catch (C2157kg e3) {
            this.A04.AHU(AHU2, 2113, e3.toString(), null, null, lx3);
            if (!this.A08) {
                return null;
            }
            Log.e(A0B, A03, e3);
            return null;
        } catch (C2164kn e4) {
            this.A04.AHU(AHU, 2119, e4.toString(), null, null, lx2);
            if (!this.A08) {
                return null;
            }
            Log.e(A0B, A03, e4);
            return null;
        }
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-95, -23, -30, -12, -95, -29, -26, -26, -17, -95, -22, -17, -11, -26, -13, -13, -10, -15, -11, -26, -27, -81, Byte.MIN_VALUE, 116, -70, -67, -64, -71, 116, -73, -64, -71, -75, -62, -71, -72, -114, 116, -52, -66, -33, Ascii.DC2, Ascii.DC2, 3, Ascii.VT, Ascii.SO, Ascii.DC2, -40, -66, -103, -73, -71, -66, -65, -60, -67, 118, -68, -65, -62, -69, 118, -71, -59, -61, -58, -62, -69, -54, -69, 118, -63, -33, -31, -26, -25, -20, -27, -98, -28, -25, -22, -29, -98, -20, -19, -14, -98, -31, -19, -21, -18, -22, -29, -14, -29, -98, -87, -57, -55, -50, -49, -44, -51, -122, -43, -52, -122, -121, -91, -78, 107, -72, 100, -89, -80, -77, -73, -87, 100, -89, -91, -89, -84, -87, 100, -86, -83, -80, -87, 114, -61, -31, -18, -89, -12, -96, -14, -27, -31, -28, -96, -31, -13, -13, -27, -12, -13, -82, -63, -33, -20, -91, -14, -98, -16, -29, -33, -30, -98, -22, -29, -20, -27, -14, -26, -98, -19, -28, -98, -124, -91, -84, -91, -76, -87, -82, -89, 96, -93, -95, -93, -88, -91, 96, -90, -87, -84, -91, 96, -95, -90, -76, -91, -78, 96, -91, -72, -93, -91, -91, -92, -87, -82, -89, 96, -78, -91, -76, -78, -71, 96, -95, -76, -76, -91, -83, -80, -76, -77, 122, 96, -120, -75, -75, -78, -75, 99, -90, -92, -90, -85, -84, -79, -86, 99, -73, -85, -88, 99, -87, -84, -81, -88, -89, -44, -44, -47, -44, -126, -59, -50, -57, -61, -48, -53, -48, -55, -126, -56, -53, -50, -57, -23, Ascii.SYN, Ascii.SYN, 19, Ascii.SYN, -60, 7, Ascii.DLE, 19, Ascii.ETB, Ascii.CR, Ascii.DC2, Ascii.VT, -60, Ascii.ETB, 19, Ascii.EM, Ascii.SYN, 7, 9, -39, -2, -13, -1, -3, 0, -4, -11, 4, -11, -80, 2, -11, 3, 0, -1, -2, 3, -11, -66, 2, 32, 39, Ascii.ETB, Ascii.FS, Ascii.NAK, -50, 34, Ascii.GS, -50, 32, 19, Ascii.SI, Ascii.DC2, -50, -31, -28, -18, -9, -83, -26, -23, -20, -27, -83, -29, -31, -29, -24, -27, -50, -32, -32, -46, -31, -89, -100, -100, -100, -77, -74, -71, -78, -121, 124, 124, 124, -82, -69, -79, -65, -68, -74, -79, -84, -82, -64, -64, -78, -63, 124};
    }

    static {
        A04();
        A0B = C2169ks.class.getSimpleName();
    }

    public C2169ks(T8 t8, LZ lz, InterfaceC1148Lm interfaceC1148Lm) {
        this.A05 = t8;
        this.A08 = lz.A02();
        this.A00 = lz.A00();
        this.A04 = interfaceC1148Lm;
        this.A01 = lz.A01();
        this.A02 = lz;
    }

    public static C2167kq A00(Context context, String str) throws C1144Li {
        try {
            InputStream open = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr, 0, bArr.length);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new C2167kq(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (IOException e) {
            throw new C1144Li(A03(Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 18, 78), e);
        }
    }

    public static File A01(Context context) {
        return new File(context.getCacheDir(), A03(Sdk.SDKError.Reason.AD_CLOSED_MISSING_HEARTBEAT_VALUE, 15, 78));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0144 A[Catch: Li -> 0x015f, all -> 0x01c6, TRY_LEAVE, TryCatch #15 {Li -> 0x015f, all -> 0x01c6, blocks: (B:95:0x007c, B:18:0x00f8, B:20:0x0100, B:25:0x0144, B:28:0x0157, B:90:0x013e), top: B:94:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0157 A[Catch: Li -> 0x015f, all -> 0x01c6, TRY_ENTER, TRY_LEAVE, TryCatch #15 {Li -> 0x015f, all -> 0x01c6, blocks: (B:95:0x007c, B:18:0x00f8, B:20:0x0100, B:25:0x0144, B:28:0x0157, B:90:0x013e), top: B:94:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0148 A[Catch: Li -> 0x009a, all -> 0x01fa, TRY_ENTER, TryCatch #14 {Li -> 0x009a, all -> 0x01fa, blocks: (B:5:0x0051, B:7:0x008b, B:26:0x0151, B:59:0x0162, B:80:0x0148, B:82:0x014e, B:87:0x0130, B:88:0x0137), top: B:4:0x0051 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A05(Context context, C2163km c2163km, String str, int i, int i2, long j) throws C1144Li {
        InterfaceC1147Ll c2158kh;
        int i3;
        String[] strArr;
        String A03 = A03(263, 20, 114);
        String A032 = A03(342, 22, 27);
        if (str.startsWith(A032)) {
            String localUrl = str.substring(A032.length());
            c2158kh = A00(context, localUrl);
        } else {
            String A033 = A03(333, 9, 59);
            if (str.startsWith(A033)) {
                String localUrl2 = str.substring(A033.length());
                c2158kh = A00(context, localUrl2);
            } else {
                c2158kh = new C2158kh(str, i);
            }
        }
        try {
            if (this.A08) {
                try {
                    try {
                        String str2 = A03(303, 15, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + str + A03(38, 11, 108) + i2;
                    } catch (C1144Li e) {
                        e = e;
                        i3 = 0;
                        try {
                            if (c2158kh instanceof C2158kh) {
                                try {
                                    i3 = ((C2158kh) c2158kh).A06();
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        c2158kh.close();
                                    } catch (C1144Li | IllegalArgumentException e2) {
                                        if (this.A08) {
                                            Log.e(A0B, A03, e2);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            try {
                                this.A05.A08().ABo(j, System.currentTimeMillis() - j, 0L, 0L, i3, null);
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                                c2158kh.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (A0A[4].charAt(27) == 'R') {
                                A0A[3] = "p8aYiN6IujE52Q2p9R2WzRwMj4wd2wO9";
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        c2158kh.close();
                        throw th;
                    }
                } catch (C1144Li e3) {
                    e = e3;
                    i3 = 0;
                    if (c2158kh instanceof C2158kh) {
                    }
                    this.A05.A08().ABo(j, System.currentTimeMillis() - j, 0L, 0L, i3, null);
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    c2158kh.close();
                    throw th;
                }
            }
            int A034 = c2163km.A03();
            int length = c2158kh.length();
            boolean z = length < 0;
            if (A0A[3].charAt(31) == '9') {
                A0A[3] = "O2qol2VIPsSIkPIIN6kN5hssl2djupr9";
                if (z) {
                    boolean A07 = A07(c2163km);
                    if (this.A08) {
                        String str3 = A03(149, 21, 76) + str + A03(22, 16, 34) + A07;
                    }
                }
                try {
                    try {
                        if (z || A034 < length) {
                            c2158kh.AGj(A034);
                            byte[] buffer = new byte[8192];
                            while (true) {
                                int read = c2158kh.read(buffer);
                                if (read != -1) {
                                    c2163km.A08(buffer, read);
                                }
                            }
                            if (!z) {
                                c2163km.A07();
                            } else if (c2163km.A03() == length) {
                                c2163km.A07();
                            } else {
                                throw new C2164kn(A03(283, 20, 94));
                            }
                            int i4 = 0;
                            if (c2158kh instanceof C2158kh) {
                                i4 = ((C2158kh) c2158kh).A06();
                            }
                            InterfaceC1340Tc A08 = this.A05.A08();
                            long currentTimeMillis = System.currentTimeMillis() - j;
                            long A035 = c2163km.A03();
                            strArr = A0A;
                            if (strArr[2].length() == strArr[5].length()) {
                                A0A[0] = "LJMphR6GQubhlr";
                            } else {
                                A0A[0] = "i3csCW72L1z7Bc";
                            }
                            A08.ABo(j, currentTimeMillis, A035, 0L, i4, null);
                            c2158kh.close();
                            return;
                        }
                        c2158kh.close();
                        return;
                    } catch (C1144Li | IllegalArgumentException e4) {
                        if (this.A08) {
                            String str4 = A0B;
                            String[] strArr2 = A0A;
                            if (strArr2[2].length() != strArr2[5].length()) {
                                throw new RuntimeException();
                            }
                            A0A[1] = "AOKjIt2kEVzrEy7KBqss66";
                            Log.e(str4, A03, e4);
                            return;
                        }
                        return;
                    }
                    if (!z) {
                    }
                    int i42 = 0;
                    if (c2158kh instanceof C2158kh) {
                    }
                    InterfaceC1340Tc A082 = this.A05.A08();
                    long currentTimeMillis2 = System.currentTimeMillis() - j;
                    long A0352 = c2163km.A03();
                    strArr = A0A;
                    if (strArr[2].length() == strArr[5].length()) {
                    }
                    A082.ABo(j, currentTimeMillis2, A0352, 0L, i42, null);
                } catch (C1144Li e5) {
                    e = e5;
                    i3 = 0;
                    if (c2158kh instanceof C2158kh) {
                    }
                    this.A05.A08().ABo(j, System.currentTimeMillis() - j, 0L, 0L, i3, null);
                    throw e;
                } catch (Throwable th6) {
                    th = th6;
                    c2158kh.close();
                    throw th;
                }
            }
            throw new RuntimeException();
        } catch (C1144Li e6) {
            e = e6;
            if (A0A[0].length() == 14) {
                String[] strArr3 = A0A;
                strArr3[2] = "7VHRmmesbfeDqucWLtEKLKcMBQJVNm";
                strArr3[5] = "oM47EpnTTF1S9ikTK6B0AzPGZuSKH0";
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private void A06(C2163km c2163km) {
        try {
            File A04 = c2163km.A04();
            if (A04.exists()) {
                c2163km.A06();
                boolean delete = A04.delete();
                if (this.A08) {
                    Log.i(A0B, A03(170, 52, 14) + delete);
                }
            }
        } catch (Exception e) {
            if (A0A[0].length() != 14) {
                throw new RuntimeException();
            }
            A0A[3] = "fJTJjiotuyJvZrF72L8221tI8VUznJb9";
            if (this.A08) {
                Log.e(A0B, A03(108, 23, 18), e);
            }
        }
    }

    private boolean A07(C2163km c2163km) {
        try {
            c2163km.A05();
            if (A0A[4].charAt(27) != 'R') {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[7] = "zmS4hUlvHkaHxqc9Vg18exvolw";
            strArr[6] = "qC";
            return true;
        } catch (C2157kg e) {
            if (this.A08) {
                Log.e(A0B, A03(244, 19, 48), e);
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.La != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final <T> LT<T> A08(LX lx, C1136La<T> c1136La) {
        Semaphore semaphore;
        if (c1136La.A03()) {
            File file = this.A06.get(lx.A09);
            if (file != null) {
                this.A04.AHV(lx.A09, true, lx);
                return c1136La.A00().A3x(file, this.A04);
            }
            this.A04.AHV(lx.A09, false, lx);
            return new LT<>(false, null);
        }
        String str = lx.A09;
        String str2 = lx.A04;
        StringBuilder sb = new StringBuilder();
        String baseUrl = this.A03.A03(str);
        String extension = sb.append(baseUrl).append(str2).toString();
        synchronized (this.A07) {
            semaphore = this.A07.get(extension);
            if (semaphore == null) {
                semaphore = new Semaphore(1);
                this.A07.put(extension, semaphore);
            }
            try {
            } catch (Throwable th) {
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(extension);
                    throw th;
                }
            }
        }
        try {
            semaphore.acquire();
            File A02 = A02(lx, str, extension, this.A01, c1136La);
            if (A02 != null) {
                LT<T> A3x = c1136La.A00().A3x(A02, this.A04);
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(extension);
                }
                return A3x;
            }
            LT<T> lt = new LT<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(extension);
            }
            return lt;
        } catch (InterruptedException unused) {
            if (this.A08) {
                StringBuilder sb2 = new StringBuilder();
                String baseUrl2 = A03(97, 11, 52);
                StringBuilder append = sb2.append(baseUrl2).append(str);
                String baseUrl3 = A03(0, 22, 79);
                append.append(baseUrl3).toString();
            }
            LT<T> lt2 = new LT<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(extension);
                return lt2;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.LR
    public final LT<Bitmap> AIe(LX lx, boolean z) {
        return A08(lx, new C1136La(new C2173kx(lx.A01, lx.A00, this.A02.A04(), this.A02.A03(), z)));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.La != com.facebook.ads.cache.config.CacheRequestConfig<java.io.File> */
    @Override // com.instagram.common.viewpoint.core.LR
    public final File AIf(LX lx) {
        C1136La c1136La = new C1136La(new C2172kw());
        c1136La.A01(true);
        c1136La.A02(false);
        return (File) A08(lx, c1136La).A00();
    }

    @Override // com.instagram.common.viewpoint.core.LR
    public final String AIg(LX lx) {
        return (String) A08(lx, new C1136La(new C2171kv())).A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.La != com.facebook.ads.cache.config.CacheRequestConfig<java.lang.String> */
    @Override // com.instagram.common.viewpoint.core.LR
    public final String AIh(LX lx) {
        C1136La c1136La = new C1136La(new C2171kv());
        c1136La.A01(true);
        c1136La.A02(false);
        return (String) A08(lx, c1136La).A00();
    }
}
