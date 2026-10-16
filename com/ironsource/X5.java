package com.ironsource;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.V5;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class X5 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3124a;
    private final C3092g5 b;
    private final W5 c;
    private final C3385xb d;
    private final InterfaceC3381x7 e = C3334ub.U().i();

    public X5(Context context, C3092g5 c3092g5, W5 w5, C3385xb c3385xb) {
        this.f3124a = context;
        this.b = c3092g5;
        this.c = w5;
        this.d = c3385xb;
    }

    public void a(C3382x8 c3382x8, String str, int i, int i2, InterfaceC3386xc interfaceC3386xc) throws Exception {
        if (TextUtils.isEmpty(str)) {
            throw new Exception(V5.a.f3089a);
        }
        if (this.e.a(this.b.a()) <= 0) {
            throw new Exception(C3074f4.A);
        }
        if (!Z3.h(this.f3124a)) {
            throw new Exception(C3074f4.C);
        }
        this.c.a(c3382x8.getPath(), new a(interfaceC3386xc));
        if (!c3382x8.exists()) {
            this.b.a(c3382x8, str, i, i2, this.c);
            return;
        }
        Message message = new Message();
        message.obj = c3382x8;
        message.what = 1015;
        this.c.sendMessage(message);
    }

    public void b(C3382x8 c3382x8) throws Exception {
        if (c3382x8.exists()) {
            ArrayList<C3382x8> filesInFolderRecursive = IronSourceStorageUtils.getFilesInFolderRecursive(c3382x8);
            if (!IronSourceStorageUtils.deleteFolderContentRecursive(c3382x8) || !c3382x8.delete()) {
                throw new Exception("Failed to delete folder");
            }
            this.d.a(filesInFolderRecursive);
        }
    }

    public JSONObject c(C3382x8 c3382x8) throws Exception {
        if (c3382x8.exists()) {
            return IronSourceStorageUtils.buildFilesMapOfDirectory(c3382x8, this.d.b());
        }
        throw new Exception("Folder does not exist");
    }

    public long d(C3382x8 c3382x8) throws Exception {
        if (c3382x8.exists()) {
            return IronSourceStorageUtils.getTotalSizeOfDir(c3382x8);
        }
        throw new Exception("Folder does not exist");
    }

    class a implements InterfaceC3386xc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3386xc f3125a;

        /* renamed from: com.ironsource.X5$a$a, reason: collision with other inner class name */
        class C0282a extends JSONObject {
            C0282a() throws JSONException {
                put("lastReferencedTime", System.currentTimeMillis());
            }
        }

        a(InterfaceC3386xc interfaceC3386xc) {
            this.f3125a = interfaceC3386xc;
        }

        @Override // com.ironsource.InterfaceC3386xc
        public void a(C3382x8 c3382x8) {
            this.f3125a.a(c3382x8);
            try {
                X5.this.d.a(c3382x8.getName(), new C0282a());
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.ironsource.InterfaceC3386xc
        public void a(C3382x8 c3382x8, C3247p8 c3247p8) {
            this.f3125a.a(c3382x8, c3247p8);
        }
    }

    public void a(C3382x8 c3382x8) throws Exception {
        if (c3382x8.exists()) {
            if (c3382x8.delete()) {
                this.d.a(c3382x8.getName());
                return;
            }
            throw new Exception("Failed to delete file");
        }
    }

    public void a(C3382x8 c3382x8, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            if (c3382x8.exists()) {
                if (!this.d.b(c3382x8.getName(), jSONObject)) {
                    throw new Exception("Failed to update attribute");
                }
                return;
            }
            throw new Exception("File does not exist");
        }
        throw new Exception("Missing attributes to update");
    }
}
