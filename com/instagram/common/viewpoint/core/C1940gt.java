package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.gt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1940gt implements SR {
    public static byte[] A03;
    public static String[] A04 = {"1hpByTARN6eOnQ", "46DvCO0dFj9d90pc7Bl3Va1pW3afVu0G", "LtfSHnVMNf9jD1VPw2QJdb6akNXb3KRw", "UXeRQ2HNaneiXsHAoGvRBzblNiVPPyfq", "WcHPi3i27m6LdaHLnkH9ENRpFxyJu3g8", "FTcDokCppzFM6olvGfJVNXVubstDZ8VZ", "v3Z7C81p3UBYKX6nY0MAEeka3DNz7RKw", "vwYfKziuTy1RLYscQHjTEDI4uYjWuvBq"};
    public final InterfaceC1905gK A01;
    public Set<SU> A00 = new HashSet();
    public final List<ST> A02 = new ArrayList();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 81);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{75, 75, 78, Ascii.CAN, 81, 75, 78, Ascii.CAN, 39, 53, 53, 35, 50, 53};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public synchronized void A03() {
        if (!this.A01.AAe()) {
            BuildConfigApi.isDebug();
            return;
        }
        Set<SU> A01 = A01(this.A01.A7i());
        if (!this.A00.equals(A01) && A01 != null) {
            this.A00 = A01;
            Iterator<ST> it = this.A02.iterator();
            while (it.hasNext()) {
                it.next().A4J();
            }
        }
        if (BuildConfigApi.isDebug()) {
            for (SU su : this.A00) {
                String.format(Locale.US, A00(0, 8, 58), su.A9O(), su.getUrl());
            }
        }
    }

    static {
        A02();
    }

    public C1940gt(CY cy) {
        this.A01 = cy.A5U(EnumC1906gL.A0B);
        this.A01.A41(new C1941gu(this));
        A03();
    }

    public static Set<SU> A01(JSONObject jSONObject) {
        C1939gs A00;
        HashSet hashSet = new HashSet();
        JSONArray optJSONArray = jSONObject.optJSONArray(A00(8, 6, 23));
        if (optJSONArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = optJSONArray.length();
            if (A04[2].charAt(7) != 'M') {
                throw new RuntimeException();
            }
            A04[0] = "HjevAVNXdTQxpc55Yqf8Zim5Y";
            if (i < i2) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject == null || (A00 = C1939gs.A00(optJSONObject)) == null) {
                    return null;
                }
                hashSet.add(A00);
                i++;
            } else {
                return hashSet;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.SR
    public final void A40(ST st) {
        this.A02.add(st);
    }

    @Override // com.instagram.common.viewpoint.core.SR
    public final synchronized Set<SU> A6x() {
        return new HashSet(this.A00);
    }
}
