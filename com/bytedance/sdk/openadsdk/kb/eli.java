package com.bytedance.sdk.openadsdk.kb;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import com.bytedance.sdk.component.DbA.eli.FC;
import com.bytedance.sdk.component.DbA.eli.MGA;
import com.bytedance.sdk.component.DbA.eli.NU;
import com.bytedance.sdk.component.DbA.eli.Os;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.bytedance.sdk.component.DbA.eli.ui;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class eli implements INetWork {
    protected du eli = new du.eli().eli(10, TimeUnit.SECONDS).DbA(10, TimeUnit.SECONDS).Os(10, TimeUnit.SECONDS).eli();
    protected du DbA = new du.eli().eli(10, TimeUnit.SECONDS).DbA(30, TimeUnit.SECONDS).Os(30, TimeUnit.SECONDS).eli();

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void syncDoGet(final String str) {
        this.eli.eli(new nlS.eli().eli().DbA(str).eli("gecko").DbA()).eli(new Os() { // from class: com.bytedance.sdk.openadsdk.kb.eli.1
            @Override // com.bytedance.sdk.component.DbA.eli.Os
            public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, nn nnVar) throws IOException {
            }

            @Override // com.bytedance.sdk.component.DbA.eli.Os
            public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, IOException iOException) {
            }
        });
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doGet(String str) throws Exception {
        nn DbA = this.eli.eli(new nlS.eli().eli().DbA(str).eli("gecko").DbA()).DbA();
        return new Response(eli(DbA.kb()), DbA.Os() == 200 ? DbA.MGA().DbA() : null, DbA.Os(), DbA.ui());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        ui.eli eliVar = new ui.eli();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                eliVar.eli((String) pair.first, (String) pair.second);
            }
        }
        nn DbA = this.eli.eli(new nlS.eli().DbA(str).eli((NU) eliVar.eli()).eli("gecko").DbA()).DbA();
        return new Response(eli(DbA.kb()), DbA.Os() == 200 ? DbA.MGA().DbA() : null, DbA.Os(), DbA.ui());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, String str2) throws Exception {
        nn DbA = this.eli.eli(new nlS.eli().DbA(str).eli(NU.eli(FC.eli("application/json; charset=utf-8"), str2)).eli("gecko").DbA()).DbA();
        return new Response(eli(DbA.kb()), DbA.Os() == 200 ? DbA.MGA().DbA() : null, DbA.Os(), DbA.ui());
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0081: MOVE (r7 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x0081 */
    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void downloadFile(String str, long j, BufferOutputStream bufferOutputStream) throws Exception {
        Exception e;
        Closeable closeable;
        int Os;
        BufferedInputStream bufferedInputStream;
        Closeable closeable2 = null;
        int i = 0;
        try {
            try {
                try {
                    nn DbA = this.DbA.eli(new nlS.eli().eli().eli("gecko").DbA(str).DbA()).DbA();
                    Os = DbA.Os();
                    try {
                        bufferedInputStream = new BufferedInputStream(DbA.MGA().Os());
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    CloseableUtils.close(closeable2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read != -1) {
                        bufferOutputStream.write(bArr, 0, read);
                    } else {
                        CloseableUtils.close(bufferedInputStream);
                        return;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                i = Os;
                throw new RuntimeException("downloadFile failed, code: " + i + ", url:" + str + ", caused by:" + e.getMessage(), e);
            }
        } catch (Throwable th2) {
            th = th2;
            CloseableUtils.close(closeable2);
            throw th;
        }
    }

    private Map<String, String> eli(MGA mga) {
        if (mga == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < mga.eli(); i++) {
            hashMap.put(mga.eli(i), mga.DbA(i));
        }
        return hashMap;
    }
}
