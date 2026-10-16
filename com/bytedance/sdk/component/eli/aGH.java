package com.bytedance.sdk.component.eli;

/* loaded from: classes3.dex */
public abstract class aGH<P, R> extends com.bytedance.sdk.component.eli.DbA<P, R> {
    private eli DbA;
    private MGA Os;
    private boolean eli = true;

    public interface DbA {
        aGH eli();
    }

    interface eli {
        void eli(Object obj);

        void eli(Throwable th);
    }

    protected abstract void eli(P p, MGA mga) throws Exception;

    @Override // com.bytedance.sdk.component.eli.DbA
    public /* bridge */ /* synthetic */ String eli() {
        return super.eli();
    }

    protected final void eli(R r) {
        if (MGA()) {
            this.DbA.eli(r);
            aGH();
        }
    }

    protected final void eli(Throwable th) {
        if (MGA()) {
            this.DbA.eli(th);
            aGH();
        }
    }

    protected final void Os() {
        eli((Throwable) null);
    }

    protected void aGH() {
        this.eli = false;
        this.Os = null;
    }

    void eli(P p, MGA mga, eli eliVar) throws Exception {
        this.Os = mga;
        this.DbA = eliVar;
        eli(p, mga);
    }

    void ui() {
        aGH();
    }

    private boolean MGA() {
        if (this.eli) {
            return true;
        }
        FC.eli(new IllegalStateException("Jsb async call already finished: " + eli() + ", hashcode: " + hashCode()));
        return false;
    }
}
