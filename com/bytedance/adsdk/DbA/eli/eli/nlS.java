package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Path;
import com.bytedance.adsdk.DbA.Os.DbA.FC;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class nlS implements NU, aAs {
    private final com.bytedance.adsdk.DbA.Os.DbA.FC MGA;
    private final String aGH;
    private final Path eli = new Path();
    private final Path DbA = new Path();
    private final Path Os = new Path();
    private final List<NU> ui = new ArrayList();

    public nlS(com.bytedance.adsdk.DbA.Os.DbA.FC fc) {
        this.aGH = fc.eli();
        this.MGA = fc;
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.aAs
    public void eli(ListIterator<Os> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Os previous = listIterator.previous();
            if (previous instanceof NU) {
                this.ui.add((NU) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        for (int i = 0; i < this.ui.size(); i++) {
            this.ui.get(i).eli(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.NU
    public Path aGH() {
        this.Os.reset();
        if (this.MGA.Os()) {
            return this.Os;
        }
        int i = AnonymousClass1.eli[this.MGA.DbA().ordinal()];
        if (i == 1) {
            eli();
        } else if (i == 2) {
            eli(Path.Op.UNION);
        } else if (i == 3) {
            eli(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            eli(Path.Op.INTERSECT);
        } else if (i == 5) {
            eli(Path.Op.XOR);
        }
        return this.Os;
    }

    /* renamed from: com.bytedance.adsdk.DbA.eli.eli.nlS$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[FC.eli.values().length];
            eli = iArr;
            try {
                iArr[FC.eli.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[FC.eli.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[FC.eli.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eli[FC.eli.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eli[FC.eli.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void eli() {
        for (int i = 0; i < this.ui.size(); i++) {
            this.Os.addPath(this.ui.get(i).aGH());
        }
    }

    private void eli(Path.Op op) {
        this.DbA.reset();
        this.eli.reset();
        for (int size = this.ui.size() - 1; size > 0; size--) {
            NU nu = this.ui.get(size);
            if (nu instanceof aGH) {
                aGH agh = (aGH) nu;
                List<NU> DbA = agh.DbA();
                for (int size2 = DbA.size() - 1; size2 >= 0; size2--) {
                    Path aGH = DbA.get(size2).aGH();
                    aGH.transform(agh.Os());
                    this.DbA.addPath(aGH);
                }
            } else {
                this.DbA.addPath(nu.aGH());
            }
        }
        NU nu2 = this.ui.get(0);
        if (nu2 instanceof aGH) {
            aGH agh2 = (aGH) nu2;
            List<NU> DbA2 = agh2.DbA();
            for (int i = 0; i < DbA2.size(); i++) {
                Path aGH2 = DbA2.get(i).aGH();
                aGH2.transform(agh2.Os());
                this.eli.addPath(aGH2);
            }
        } else {
            this.eli.set(nu2.aGH());
        }
        this.Os.op(this.eli, this.DbA, op);
    }
}
