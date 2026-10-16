package com.inmobi.media;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.g7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2664g7 extends N9 {
    public final Y6 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2664g7(String url, Y6 data) {
        super("POST", url, (C2897ue) null, true, (InterfaceC2971z5) null, com.ironsource.D5.L, 64);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(data, "data");
        this.y = data;
    }

    public static String a(String str) {
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine).append('\n');
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @Override // com.inmobi.media.N9
    public final void f() {
        super.f();
        this.t = false;
        this.u = false;
        this.x = false;
        try {
            this.l = new JSONObject(a(this.y.f2492a));
        } catch (FileNotFoundException unused) {
            String str = "File - " + this.y.f2492a + " not found";
            P9 response = new P9();
            response.d = new I9(EnumC2790o4.s, str);
            Intrinsics.checkNotNullParameter(response, "response");
            this.n = response;
        } catch (IOException unused2) {
            String str2 = "IOException while reading file - " + this.y.f2492a;
            P9 response2 = new P9();
            response2.d = new I9(EnumC2790o4.s, str2);
            Intrinsics.checkNotNullParameter(response2, "response");
            this.n = response2;
        } catch (JSONException unused3) {
            String str3 = "JSON exception while parsing file - " + this.y.f2492a;
            P9 response3 = new P9();
            response3.d = new I9(EnumC2790o4.s, str3);
            Intrinsics.checkNotNullParameter(response3, "response");
            this.n = response3;
        }
    }
}
