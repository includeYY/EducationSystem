package com.lepetit.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.lepetit.greendaohelper.ScheduleInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SCHEDULE_INFO".
*/
public class ScheduleInfoDao extends AbstractDao<ScheduleInfo, Long> {

    public static final String TABLENAME = "SCHEDULE_INFO";

    /**
     * Properties of entity ScheduleInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Day = new Property(1, String.class, "day", false, "Day");
        public final static Property Course = new Property(2, String.class, "course", false, "Course");
        public final static Property Teacher = new Property(3, String.class, "teacher", false, "Teacher");
        public final static Property Week = new Property(4, String.class, "week", false, "Week");
        public final static Property Time = new Property(5, String.class, "time", false, "Time");
        public final static Property Classroom = new Property(6, String.class, "classroom", false, "Classroom");
        public final static Property LastWeek = new Property(7, String.class, "lastWeek", false, "LastWeek");
    }


    public ScheduleInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ScheduleInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SCHEDULE_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"Day\" TEXT," + // 1: day
                "\"Course\" TEXT," + // 2: course
                "\"Teacher\" TEXT," + // 3: teacher
                "\"Week\" TEXT," + // 4: week
                "\"Time\" TEXT," + // 5: time
                "\"Classroom\" TEXT," + // 6: classroom
                "\"LastWeek\" TEXT);"); // 7: lastWeek
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SCHEDULE_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ScheduleInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String day = entity.getDay();
        if (day != null) {
            stmt.bindString(2, day);
        }
 
        String course = entity.getCourse();
        if (course != null) {
            stmt.bindString(3, course);
        }
 
        String teacher = entity.getTeacher();
        if (teacher != null) {
            stmt.bindString(4, teacher);
        }
 
        String week = entity.getWeek();
        if (week != null) {
            stmt.bindString(5, week);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(6, time);
        }
 
        String classroom = entity.getClassroom();
        if (classroom != null) {
            stmt.bindString(7, classroom);
        }
 
        String lastWeek = entity.getLastWeek();
        if (lastWeek != null) {
            stmt.bindString(8, lastWeek);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ScheduleInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String day = entity.getDay();
        if (day != null) {
            stmt.bindString(2, day);
        }
 
        String course = entity.getCourse();
        if (course != null) {
            stmt.bindString(3, course);
        }
 
        String teacher = entity.getTeacher();
        if (teacher != null) {
            stmt.bindString(4, teacher);
        }
 
        String week = entity.getWeek();
        if (week != null) {
            stmt.bindString(5, week);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(6, time);
        }
 
        String classroom = entity.getClassroom();
        if (classroom != null) {
            stmt.bindString(7, classroom);
        }
 
        String lastWeek = entity.getLastWeek();
        if (lastWeek != null) {
            stmt.bindString(8, lastWeek);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ScheduleInfo readEntity(Cursor cursor, int offset) {
        ScheduleInfo entity = new ScheduleInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // day
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // course
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // teacher
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // week
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // time
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // classroom
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // lastWeek
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ScheduleInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDay(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCourse(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTeacher(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setWeek(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setClassroom(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLastWeek(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ScheduleInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ScheduleInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ScheduleInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
