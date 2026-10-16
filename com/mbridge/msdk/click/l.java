package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import java.net.URI;
import java.util.concurrent.Semaphore;

/* compiled from: SocketRequestTask.java */
/* loaded from: classes6.dex */
public class l extends com.mbridge.msdk.foundation.same.task.a {
    private final Context b;
    private final String c;
    private final String d;
    private final String e;
    private final CampaignEx f;
    private final boolean g;
    private final boolean h;
    private final int i;
    private final boolean j;
    private com.mbridge.msdk.click.entity.a k;
    private JumpLoaderResult l;
    private g m;
    private k n;

    /* renamed from: a, reason: collision with root package name */
    private final Semaphore f4044a = new Semaphore(0);
    private final o.f o = new a();

    public l(com.mbridge.msdk.click.entity.b bVar) {
        this.b = bVar.c();
        this.c = bVar.e();
        this.d = bVar.b();
        this.e = bVar.d();
        this.f = bVar.a();
        this.g = bVar.g();
        this.h = bVar.i();
        this.i = bVar.f();
        this.j = bVar.h();
    }

    @Override // com.mbridge.msdk.foundation.same.task.a
    public void cancelTask() {
    }

    @Override // com.mbridge.msdk.foundation.same.task.a
    public void pauseTask(boolean z) {
    }

    @Override // com.mbridge.msdk.foundation.same.task.a
    public void runTask() {
        JumpLoaderResult jumpLoaderResult;
        g gVar = this.m;
        if (gVar != null) {
            gVar.b(null);
        }
        JumpLoaderResult jumpLoaderResult2 = new JumpLoaderResult();
        this.l = jumpLoaderResult2;
        jumpLoaderResult2.setUrl(this.c);
        JumpLoaderResult c = c(this.c);
        this.l = c;
        if (c != null && !TextUtils.isEmpty(c.getExceptionMsg())) {
            this.l.setSuccess(true);
        }
        if (this.mState != a.b.RUNNING) {
            k kVar = this.n;
            if (kVar != null) {
                kVar.a(this.l);
                return;
            }
            return;
        }
        JumpLoaderResult jumpLoaderResult3 = this.l;
        if (jumpLoaderResult3 != null && !jumpLoaderResult3.isSuccess()) {
            k kVar2 = this.n;
            if (kVar2 != null) {
                kVar2.a(this.l);
                return;
            }
            return;
        }
        com.mbridge.msdk.click.entity.a aVar = this.k;
        if (aVar != null && (jumpLoaderResult = this.l) != null) {
            jumpLoaderResult.setStatusCode(aVar.f);
        }
        m.a(this.f, this.l, this.k, this.d, this.e, this.b, this.o, this.n, this.f4044a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        return m.a(str, this.f, this.l);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016d A[EDGE_INSN: B:72:0x016d->B:34:0x016d BREAK  A[LOOP:0: B:11:0x003c->B:53:0x0165], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JumpLoaderResult c(String str) {
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        String str5;
        String a2 = a(str);
        JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
        n nVar = new n();
        i iVar = new i();
        String str6 = "";
        try {
        } catch (Exception e) {
            e = e;
            str2 = "";
        }
        if (!URLUtil.isNetworkUrl(a2)) {
            str3 = "";
            str4 = a2;
            i = 0;
            while (true) {
                if (i >= 10) {
                }
                str4 = a(str5);
                i++;
            }
            return jumpLoaderResult;
        }
        URI create = URI.create(a2);
        str2 = create.getScheme();
        try {
            str6 = create.getHost();
        } catch (Exception e2) {
            e = e2;
            p0.b("SocketRequestTask", e.getMessage());
            str3 = str6;
            str6 = str2;
            str4 = a2;
            i = 0;
            while (true) {
                if (i >= 10) {
                }
                str4 = a(str5);
                i++;
            }
            return jumpLoaderResult;
        }
        str3 = str6;
        str6 = str2;
        str4 = a2;
        i = 0;
        while (true) {
            if (i >= 10) {
                break;
            }
            if (this.mState != a.b.RUNNING) {
                return null;
            }
            if (str4.startsWith("tcp")) {
                this.k = nVar.a(str4, this.f, this.g, this.h);
                i2 = 3;
            } else {
                this.k = iVar.a(str4, this.g, this.h, this.f);
                i2 = 1;
            }
            com.mbridge.msdk.click.entity.a aVar = this.k;
            if (aVar == null) {
                jumpLoaderResult.setUrl(str4);
                jumpLoaderResult.setSuccess(false);
                break;
            }
            if (TextUtils.isEmpty(aVar.h)) {
                int i3 = this.k.f;
                if (i3 == 200) {
                    jumpLoaderResult.setjumpDone(true);
                    jumpLoaderResult.setUrl(str4);
                    jumpLoaderResult.setSuccess(true);
                    String str7 = this.k.g;
                    jumpLoaderResult.setContent(str7 != null ? str7 : null);
                } else if (i3 == 301 || i3 == 302 || i3 == 307) {
                    jumpLoaderResult.setSuccess(true);
                    jumpLoaderResult.setIs302Jump(true);
                    if (TextUtils.isEmpty(this.k.f4039a)) {
                        jumpLoaderResult.setjumpDone(true);
                        jumpLoaderResult.setUrl(str4);
                        break;
                    }
                    str5 = this.k.f4039a;
                    if (!str5.startsWith("http")) {
                        if (!str5.startsWith(RemoteSettings.FORWARD_SLASH_STRING) || TextUtils.isEmpty(str6) || TextUtils.isEmpty(str3)) {
                            break;
                        }
                        str5 = str6 + "://" + str3 + str5;
                        str3 = null;
                        str6 = null;
                    }
                    if (t0.a.b(str5)) {
                        jumpLoaderResult.setjumpDone(true);
                        jumpLoaderResult.setUrl(str5);
                        break;
                    }
                    str4 = a(str5);
                    i++;
                } else {
                    jumpLoaderResult.setjumpDone(false);
                    jumpLoaderResult.setUrl(str4);
                    if (i == 0) {
                        com.mbridge.msdk.click.retry.a.b().a(str4, this.k.h, this.f, this.e, this.g, this.h, this.i);
                    }
                }
            } else {
                jumpLoaderResult.setUrl(str4);
                jumpLoaderResult.setExceptionMsg(this.k.h);
                jumpLoaderResult.setType(i2);
                jumpLoaderResult.setHeader(this.k.a());
                jumpLoaderResult.setSuccess(false);
                if (i == 0) {
                    com.mbridge.msdk.click.retry.a.b().a(str4, this.k.h, this.f, this.e, this.g, this.h, this.i);
                }
            }
        }
        return jumpLoaderResult;
    }

    /* compiled from: SocketRequestTask.java */
    class a implements o.f {
        a() {
        }

        @Override // com.mbridge.msdk.click.o.f
        public boolean a(String str) {
            boolean b = l.this.b(str);
            if (b) {
                a();
            }
            return b;
        }

        @Override // com.mbridge.msdk.click.o.f
        public boolean b(String str) {
            return false;
        }

        @Override // com.mbridge.msdk.click.o.f
        public boolean c(String str) {
            boolean b = l.this.b(str);
            if (b) {
                a();
            }
            return b;
        }

        @Override // com.mbridge.msdk.click.o.f
        public void a(String str, boolean z, String str2) {
            l.this.b(str);
            l.this.l.setContent(str2);
            a();
        }

        private void a() {
            synchronized (this) {
                l.this.l.setSuccess(true);
                if (l.this.n != null) {
                    l.this.n.a(l.this.l);
                }
                l.this.a();
            }
        }

        @Override // com.mbridge.msdk.click.o.f
        public void a(int i, String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str2)) {
                l.this.l.setExceptionMsg(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                l.this.l.setContent(str3);
            }
            l.this.b(str);
            a();
        }
    }

    public void a(g gVar) {
        this.m = gVar;
    }

    public void a(k kVar) {
        this.n = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f4044a.release();
    }

    private String a(String str) {
        if (this.j) {
            String a2 = com.mbridge.msdk.setting.b.a(this.b, str);
            if (!TextUtils.isEmpty(a2)) {
                str = str + a2;
            }
        }
        return com.mbridge.msdk.util.b.a() ? m.a(this.f, str) : str;
    }
}
