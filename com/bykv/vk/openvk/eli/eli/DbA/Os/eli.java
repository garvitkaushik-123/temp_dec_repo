package com.bykv.vk.openvk.eli.eli.DbA.Os;

import com.bykv.vk.openvk.eli.eli.DbA.Os.Os;

/* loaded from: classes3.dex */
public abstract class eli implements Os {
    private Os.ui DbA;
    private Os.kb MGA;
    private Os.DbA Os;
    private Os.eli aGH;
    protected boolean eli = false;
    private Os.InterfaceC0108Os kb;
    private Os.MGA ui;
    private Os.aGH wC;

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public final void eli(Os.ui uiVar) {
        this.DbA = uiVar;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public final void eli(Os.DbA dbA) {
        this.Os = dbA;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public final void eli(Os.eli eliVar) {
        this.aGH = eliVar;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public final void eli(Os.MGA mga) {
        this.ui = mga;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public final void eli(Os.InterfaceC0108Os interfaceC0108Os) {
        this.kb = interfaceC0108Os;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public final void eli(Os.aGH agh) {
        this.wC = agh;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public final void eli(Os.kb kbVar) {
        this.MGA = kbVar;
    }

    public void eli() {
        this.DbA = null;
        this.aGH = null;
        this.Os = null;
        this.ui = null;
        this.MGA = null;
        this.kb = null;
        this.wC = null;
    }

    protected final void DbA() {
        try {
            Os.ui uiVar = this.DbA;
            if (uiVar != null) {
                uiVar.DbA(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void Os() {
        try {
            Os.DbA dbA = this.Os;
            if (dbA != null) {
                dbA.eli(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void eli(int i) {
        try {
            Os.eli eliVar = this.aGH;
            if (eliVar != null) {
                eliVar.eli(this, i);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void aGH() {
        try {
            Os.MGA mga = this.ui;
            if (mga != null) {
                mga.Os(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void eli(int i, int i2, int i3, int i4) {
        try {
            Os.kb kbVar = this.MGA;
            if (kbVar != null) {
                kbVar.eli(this, i, i2, i3, i4);
            }
        } catch (Throwable unused) {
        }
    }

    protected final boolean eli(int i, int i2) {
        try {
            Os.InterfaceC0108Os interfaceC0108Os = this.kb;
            if (interfaceC0108Os != null) {
                if (interfaceC0108Os.eli(this, i, i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    protected final boolean DbA(int i, int i2) {
        try {
            Os.aGH agh = this.wC;
            if (agh != null) {
                if (agh.DbA(this, i, i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.Os.Os
    public void eli(boolean z) {
        this.eli = z;
    }
}
