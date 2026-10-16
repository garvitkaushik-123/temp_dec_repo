package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase __db) {
        this.__db = __db;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9 A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x0011, B:4:0x0039, B:6:0x003f, B:8:0x004b, B:9:0x0053, B:12:0x005f, B:17:0x0068, B:18:0x007b, B:31:0x00cd, B:33:0x00d9, B:34:0x00de, B:36:0x00ec, B:38:0x00f1, B:40:0x00c8, B:41:0x00bd, B:42:0x00a5, B:45:0x00b1, B:46:0x00ad, B:47:0x0095, B:48:0x0085, B:51:0x008c), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x0011, B:4:0x0039, B:6:0x003f, B:8:0x004b, B:9:0x0053, B:12:0x005f, B:17:0x0068, B:18:0x007b, B:31:0x00cd, B:33:0x00d9, B:34:0x00de, B:36:0x00ec, B:38:0x00f1, B:40:0x00c8, B:41:0x00bd, B:42:0x00a5, B:45:0x00b1, B:46:0x00ad, B:47:0x0095, B:48:0x0085, B:51:0x008c), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8 A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x0011, B:4:0x0039, B:6:0x003f, B:8:0x004b, B:9:0x0053, B:12:0x005f, B:17:0x0068, B:18:0x007b, B:31:0x00cd, B:33:0x00d9, B:34:0x00de, B:36:0x00ec, B:38:0x00f1, B:40:0x00c8, B:41:0x00bd, B:42:0x00a5, B:45:0x00b1, B:46:0x00ad, B:47:0x0095, B:48:0x0085, B:51:0x008c), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x0011, B:4:0x0039, B:6:0x003f, B:8:0x004b, B:9:0x0053, B:12:0x005f, B:17:0x0068, B:18:0x007b, B:31:0x00cd, B:33:0x00d9, B:34:0x00de, B:36:0x00ec, B:38:0x00f1, B:40:0x00c8, B:41:0x00bd, B:42:0x00a5, B:45:0x00b1, B:46:0x00ad, B:47:0x0095, B:48:0x0085, B:51:0x008c), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5 A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x0011, B:4:0x0039, B:6:0x003f, B:8:0x004b, B:9:0x0053, B:12:0x005f, B:17:0x0068, B:18:0x007b, B:31:0x00cd, B:33:0x00d9, B:34:0x00de, B:36:0x00ec, B:38:0x00f1, B:40:0x00c8, B:41:0x00bd, B:42:0x00a5, B:45:0x00b1, B:46:0x00ad, B:47:0x0095, B:48:0x0085, B:51:0x008c), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095 A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x0011, B:4:0x0039, B:6:0x003f, B:8:0x004b, B:9:0x0053, B:12:0x005f, B:17:0x0068, B:18:0x007b, B:31:0x00cd, B:33:0x00d9, B:34:0x00de, B:36:0x00ec, B:38:0x00f1, B:40:0x00c8, B:41:0x00bd, B:42:0x00a5, B:45:0x00b1, B:46:0x00ad, B:47:0x0095, B:48:0x0085, B:51:0x008c), top: B:2:0x0011 }] */
    @Override // androidx.work.impl.model.RawWorkInfoDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(final SupportSQLiteQuery query) {
        String string;
        WorkInfo.State intToState;
        Data fromByteArray;
        ArrayList<String> arrayList;
        ArrayList<Data> arrayList2;
        this.__db.assertNotSuspendingTransaction();
        Cursor query2 = DBUtil.query(this.__db, query, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query2, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
            int columnIndex5 = CursorUtil.getColumnIndex(query2, "generation");
            ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
            while (query2.moveToNext()) {
                String string2 = query2.getString(columnIndex);
                if (arrayMap.get(string2) == null) {
                    arrayMap.put(string2, new ArrayList<>());
                }
                String string3 = query2.getString(columnIndex);
                if (arrayMap2.get(string3) == null) {
                    arrayMap2.put(string3, new ArrayList<>());
                }
            }
            query2.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList3 = new ArrayList(query2.getCount());
            while (query2.moveToNext()) {
                if (columnIndex != -1 && !query2.isNull(columnIndex)) {
                    string = query2.getString(columnIndex);
                    if (columnIndex2 != -1) {
                        intToState = null;
                    } else {
                        int i = query2.getInt(columnIndex2);
                        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                        intToState = WorkTypeConverters.intToState(i);
                    }
                    if (columnIndex3 != -1) {
                        fromByteArray = null;
                    } else {
                        fromByteArray = Data.fromByteArray(query2.isNull(columnIndex3) ? null : query2.getBlob(columnIndex3));
                    }
                    int i2 = columnIndex4 != -1 ? 0 : query2.getInt(columnIndex4);
                    int i3 = columnIndex5 != -1 ? query2.getInt(columnIndex5) : 0;
                    arrayList = arrayMap.get(query2.getString(columnIndex));
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    ArrayList<String> arrayList4 = arrayList;
                    arrayList2 = arrayMap2.get(query2.getString(columnIndex));
                    if (arrayList2 != null) {
                        arrayList2 = new ArrayList<>();
                    }
                    arrayList3.add(new WorkSpec.WorkInfoPojo(string, intToState, fromByteArray, i2, i3, arrayList4, arrayList2));
                }
                string = null;
                if (columnIndex2 != -1) {
                }
                if (columnIndex3 != -1) {
                }
                if (columnIndex4 != -1) {
                }
                int i32 = columnIndex5 != -1 ? query2.getInt(columnIndex5) : 0;
                arrayList = arrayMap.get(query2.getString(columnIndex));
                if (arrayList == null) {
                }
                ArrayList<String> arrayList42 = arrayList;
                arrayList2 = arrayMap2.get(query2.getString(columnIndex));
                if (arrayList2 != null) {
                }
                arrayList3.add(new WorkSpec.WorkInfoPojo(string, intToState, fromByteArray, i2, i32, arrayList42, arrayList2));
            }
            return arrayList3;
        } finally {
            query2.close();
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery query) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.1
            /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00dc A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:3:0x0010, B:4:0x0038, B:6:0x003e, B:8:0x004a, B:9:0x0052, B:12:0x005e, B:17:0x0067, B:18:0x007e, B:31:0x00d0, B:33:0x00dc, B:34:0x00e1, B:36:0x00ef, B:38:0x00f4, B:40:0x00cb, B:41:0x00c0, B:42:0x00a8, B:45:0x00b4, B:46:0x00b0, B:47:0x0098, B:48:0x0088, B:51:0x008f), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00ef A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:3:0x0010, B:4:0x0038, B:6:0x003e, B:8:0x004a, B:9:0x0052, B:12:0x005e, B:17:0x0067, B:18:0x007e, B:31:0x00d0, B:33:0x00dc, B:34:0x00e1, B:36:0x00ef, B:38:0x00f4, B:40:0x00cb, B:41:0x00c0, B:42:0x00a8, B:45:0x00b4, B:46:0x00b0, B:47:0x0098, B:48:0x0088, B:51:0x008f), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00f4 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00cb A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:3:0x0010, B:4:0x0038, B:6:0x003e, B:8:0x004a, B:9:0x0052, B:12:0x005e, B:17:0x0067, B:18:0x007e, B:31:0x00d0, B:33:0x00dc, B:34:0x00e1, B:36:0x00ef, B:38:0x00f4, B:40:0x00cb, B:41:0x00c0, B:42:0x00a8, B:45:0x00b4, B:46:0x00b0, B:47:0x0098, B:48:0x0088, B:51:0x008f), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00c0 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:3:0x0010, B:4:0x0038, B:6:0x003e, B:8:0x004a, B:9:0x0052, B:12:0x005e, B:17:0x0067, B:18:0x007e, B:31:0x00d0, B:33:0x00dc, B:34:0x00e1, B:36:0x00ef, B:38:0x00f4, B:40:0x00cb, B:41:0x00c0, B:42:0x00a8, B:45:0x00b4, B:46:0x00b0, B:47:0x0098, B:48:0x0088, B:51:0x008f), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00a8 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:3:0x0010, B:4:0x0038, B:6:0x003e, B:8:0x004a, B:9:0x0052, B:12:0x005e, B:17:0x0067, B:18:0x007e, B:31:0x00d0, B:33:0x00dc, B:34:0x00e1, B:36:0x00ef, B:38:0x00f4, B:40:0x00cb, B:41:0x00c0, B:42:0x00a8, B:45:0x00b4, B:46:0x00b0, B:47:0x0098, B:48:0x0088, B:51:0x008f), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0098 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:3:0x0010, B:4:0x0038, B:6:0x003e, B:8:0x004a, B:9:0x0052, B:12:0x005e, B:17:0x0067, B:18:0x007e, B:31:0x00d0, B:33:0x00dc, B:34:0x00e1, B:36:0x00ef, B:38:0x00f4, B:40:0x00cb, B:41:0x00c0, B:42:0x00a8, B:45:0x00b4, B:46:0x00b0, B:47:0x0098, B:48:0x0088, B:51:0x008f), top: B:2:0x0010 }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                String string;
                WorkInfo.State intToState;
                Data fromByteArray;
                ArrayList arrayList;
                ArrayList arrayList2;
                Cursor query2 = DBUtil.query(RawWorkInfoDao_Impl.this.__db, query, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(query2, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(query2, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(query2, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(query2, "run_attempt_count");
                    int columnIndex5 = CursorUtil.getColumnIndex(query2, "generation");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query2.moveToNext()) {
                        String string2 = query2.getString(columnIndex);
                        if (((ArrayList) arrayMap.get(string2)) == null) {
                            arrayMap.put(string2, new ArrayList());
                        }
                        String string3 = query2.getString(columnIndex);
                        if (((ArrayList) arrayMap2.get(string3)) == null) {
                            arrayMap2.put(string3, new ArrayList());
                        }
                    }
                    query2.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    ArrayList arrayList3 = new ArrayList(query2.getCount());
                    while (query2.moveToNext()) {
                        if (columnIndex != -1 && !query2.isNull(columnIndex)) {
                            string = query2.getString(columnIndex);
                            if (columnIndex2 != -1) {
                                intToState = null;
                            } else {
                                int i = query2.getInt(columnIndex2);
                                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                                intToState = WorkTypeConverters.intToState(i);
                            }
                            if (columnIndex3 != -1) {
                                fromByteArray = null;
                            } else {
                                fromByteArray = Data.fromByteArray(query2.isNull(columnIndex3) ? null : query2.getBlob(columnIndex3));
                            }
                            int i2 = columnIndex4 != -1 ? 0 : query2.getInt(columnIndex4);
                            int i3 = columnIndex5 != -1 ? query2.getInt(columnIndex5) : 0;
                            arrayList = (ArrayList) arrayMap.get(query2.getString(columnIndex));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            ArrayList arrayList4 = arrayList;
                            arrayList2 = (ArrayList) arrayMap2.get(query2.getString(columnIndex));
                            if (arrayList2 != null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList3.add(new WorkSpec.WorkInfoPojo(string, intToState, fromByteArray, i2, i3, arrayList4, arrayList2));
                        }
                        string = null;
                        if (columnIndex2 != -1) {
                        }
                        if (columnIndex3 != -1) {
                        }
                        if (columnIndex4 != -1) {
                        }
                        int i32 = columnIndex5 != -1 ? query2.getInt(columnIndex5) : 0;
                        arrayList = (ArrayList) arrayMap.get(query2.getString(columnIndex));
                        if (arrayList == null) {
                        }
                        ArrayList arrayList42 = arrayList;
                        arrayList2 = (ArrayList) arrayMap2.get(query2.getString(columnIndex));
                        if (arrayList2 != null) {
                        }
                        arrayList3.add(new WorkSpec.WorkInfoPojo(string, intToState, fromByteArray, i2, i32, arrayList42, arrayList2));
                    }
                    return arrayList3;
                } finally {
                    query2.close();
                }
            }
        });
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(final ArrayMap<String, ArrayList<String>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>(999);
            int size = _map.getSize();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                arrayMap.put(_map.keyAt(i), _map.valueAt(i));
                i++;
                i2++;
                if (i2 == 999) {
                    __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    arrayMap = new ArrayMap<>(999);
                    i2 = 0;
                }
            }
            if (i2 > 0) {
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                return;
            }
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size2 = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size2);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2);
        int i3 = 1;
        for (String str : keySet) {
            if (str == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str);
            }
            i3++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<String> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(query.isNull(0) ? null : query.getString(0));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(final ArrayMap<String, ArrayList<Data>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            ArrayMap<String, ArrayList<Data>> arrayMap = new ArrayMap<>(999);
            int size = _map.getSize();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                arrayMap.put(_map.keyAt(i), _map.valueAt(i));
                i++;
                i2++;
                if (i2 == 999) {
                    __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap);
                    arrayMap = new ArrayMap<>(999);
                    i2 = 0;
                }
            }
            if (i2 > 0) {
                __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap);
                return;
            }
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size2 = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size2);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2);
        int i3 = 1;
        for (String str : keySet) {
            if (str == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str);
            }
            i3++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<Data> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(Data.fromByteArray(query.isNull(0) ? null : query.getBlob(0)));
                }
            }
        } finally {
            query.close();
        }
    }
}
