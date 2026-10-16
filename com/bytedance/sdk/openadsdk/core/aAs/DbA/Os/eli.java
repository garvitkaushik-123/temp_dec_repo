package com.bytedance.sdk.openadsdk.core.aAs.DbA.Os;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.adsdk.ugeno.DbA.Os;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.yoga.DbA.Os;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class eli extends FrameLayout {
    private final List<Os> DbA;
    private final C0178eli Os;
    private aGH aGH;
    private final RecyclerView eli;

    public eli(Context context) {
        super(context);
        this.DbA = new CopyOnWriteArrayList();
        C0178eli c0178eli = new C0178eli();
        this.Os = c0178eli;
        RecyclerView recyclerView = new RecyclerView(context);
        this.eli = recyclerView;
        addView(recyclerView);
        recyclerView.setAdapter(c0178eli);
    }

    public void setOrientation(int i) {
        if (i == 1) {
            this.eli.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        } else {
            this.eli.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        aGH agh = this.aGH;
        if (agh != null) {
            int[] eli = agh.eli(i, i2);
            super.onMeasure(eli[0], eli[1]);
        } else {
            super.onMeasure(i, i2);
        }
        aGH agh2 = this.aGH;
        if (agh2 != null) {
            agh2.ui();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        aGH agh = this.aGH;
        if (agh != null) {
            agh.MGA();
        }
        super.onLayout(z, i, i2, i3, i4);
        aGH agh2 = this.aGH;
        if (agh2 != null) {
            agh2.eli(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH agh = this.aGH;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGH agh = this.aGH;
        if (agh != null) {
            agh.wC();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGH agh = this.aGH;
        if (agh != null) {
            agh.DbA(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void eli(Os<View> os) {
        if (os == null) {
            return;
        }
        this.DbA.add(os);
        C0178eli c0178eli = this.Os;
        if (c0178eli != null) {
            c0178eli.notifyDataSetChanged();
        }
    }

    public void eli(aGH agh) {
        this.aGH = agh;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.aAs.DbA.Os.DbA dbA) {
        ViewGroup.LayoutParams layoutParams = this.eli.getLayoutParams();
        layoutParams.width = dbA.cyF();
        layoutParams.height = dbA.eU();
        this.eli.setLayoutParams(layoutParams);
    }

    private static class DbA extends RecyclerView.ViewHolder {
        private final ViewGroup eli;

        public DbA(View view) {
            super(view);
            this.eli = (ViewGroup) view;
        }

        public void eli(Os os) {
            View du = os.du();
            ViewParent parent = du.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(du);
            }
            this.eli.removeAllViews();
            this.eli.addView(du, new Os.eli(os.cyF(), os.eU()));
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.aAs.DbA.Os.eli$eli, reason: collision with other inner class name */
    private class C0178eli extends RecyclerView.Adapter<DbA> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        private C0178eli() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public DbA onCreateViewHolder(ViewGroup viewGroup, int i) {
            com.bytedance.adsdk.ugeno.yoga.DbA.Os os = new com.bytedance.adsdk.ugeno.yoga.DbA.Os(viewGroup.getContext());
            com.bytedance.adsdk.ugeno.DbA.Os os2 = (com.bytedance.adsdk.ugeno.DbA.Os) eli.this.DbA.get(i);
            os.setLayoutParams(new ViewGroup.LayoutParams(os2.cyF(), os2.eU()));
            return new DbA(os);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(DbA dbA, int i) {
            dbA.eli((com.bytedance.adsdk.ugeno.DbA.Os) eli.this.DbA.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return eli.this.DbA.size();
        }
    }
}
