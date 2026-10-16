package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.util.List;

/* loaded from: classes3.dex */
public class Uv {

    public interface DbA {
        void DbA();

        void eli();

        void eli(View view, boolean z);

        void eli(boolean z);
    }

    public static void eli(final ViewGroup viewGroup, boolean z, int i, final boolean z2, DbA dbA, List<ViewGroup> list) {
        viewGroup.setTag(520093765, dbA);
        viewGroup.setTag(520093766, Integer.valueOf(i));
        if (viewGroup.getTag(520093764) == Boolean.TRUE) {
            return;
        }
        final eli eliVar = new eli(viewGroup, z2);
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.Uv.1
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewAdded(View view, View view2) {
                        eli.this.eli = view2;
                    }

                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        eli.this.eli = null;
                    }
                });
            }
        }
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(eliVar);
        if (z) {
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.utils.Uv.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        DbA dbA2 = (DbA) viewGroup.getTag(520093765);
                        ViewGroup viewGroup2 = viewGroup;
                        Uv.DbA(viewGroup2, dbA2, (Integer) viewGroup2.getTag(520093766), z2);
                    } catch (Exception e) {
                        ApmHelper.reportCustomError("onScrollChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                    }
                }
            });
        }
        viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.Uv.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z3) {
                try {
                    DbA dbA2 = (DbA) viewGroup.getTag(520093765);
                    if (dbA2 != null) {
                        dbA2.eli(z3);
                        ViewGroup viewGroup2 = viewGroup;
                        Uv.DbA(viewGroup2, dbA2, (Integer) viewGroup2.getTag(520093766), z2);
                    }
                } catch (Exception e) {
                    ApmHelper.reportCustomError("onWindowFocusChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                }
            }
        });
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.Uv.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                DbA dbA2 = (DbA) viewGroup.getTag(520093765);
                if (dbA2 != null) {
                    dbA2.eli();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                DbA dbA2 = (DbA) viewGroup.getTag(520093765);
                if (dbA2 != null) {
                    dbA2.DbA();
                }
            }
        });
        viewGroup.setTag(520093764, Boolean.TRUE);
    }

    class eli implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ ViewGroup DbA;
        final /* synthetic */ boolean Os;
        View eli = null;

        eli(ViewGroup viewGroup, boolean z) {
            this.DbA = viewGroup;
            this.Os = z;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                DbA dbA = (DbA) this.DbA.getTag(520093765);
                if (this.eli != null) {
                    Rect rect = new Rect();
                    this.eli.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    this.DbA.getGlobalVisibleRect(rect2);
                    if (rect.contains(rect2)) {
                        if (dbA != null) {
                            dbA.eli(this.DbA, false);
                        }
                        this.DbA.setTag(520093763, Boolean.FALSE);
                        return;
                    } else {
                        if (dbA != null) {
                            dbA.eli(this.DbA, true);
                        }
                        this.DbA.setTag(520093763, Boolean.TRUE);
                        return;
                    }
                }
                ViewGroup viewGroup = this.DbA;
                Uv.DbA(viewGroup, dbA, (Integer) viewGroup.getTag(520093766), this.Os);
            } catch (Exception e) {
                ApmHelper.reportCustomError("onGlobalLayout exception " + this.DbA.getTag(520093765), "ViewUtils", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(View view, DbA dbA, Integer num, boolean z) {
        if (dbA == null) {
            return;
        }
        if (num == null) {
            num = 0;
        }
        dbA.eli(view, eli(view, num.intValue(), z));
    }

    private static boolean eli(View view, int i, boolean z) {
        return com.bytedance.sdk.openadsdk.core.nro.eli(view, 20, i, z);
    }
}
