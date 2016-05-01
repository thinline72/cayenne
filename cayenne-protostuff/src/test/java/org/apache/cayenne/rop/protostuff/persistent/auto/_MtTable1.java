package org.apache.cayenne.rop.protostuff.persistent.auto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.rop.protostuff.persistent.MtTable2;

/**
 * Class _MtTable1 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _MtTable1 extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String TABLE1_ID_PK_COLUMN = "TABLE1_ID";

    public static final Property<LocalDate> DATE_ATTRIBUTE = new Property<LocalDate>("dateAttribute");
    public static final Property<String> GLOBAL_ATTRIBUTE = new Property<String>("globalAttribute");
    public static final Property<Date> OLD_DATE_ATTRIBUTE = new Property<Date>("oldDateAttribute");
    public static final Property<String> SERVER_ATTRIBUTE = new Property<String>("serverAttribute");
    public static final Property<LocalTime> TIME_ATTRIBUTE = new Property<LocalTime>("timeAttribute");
    public static final Property<LocalDateTime> TIMESTAMP_ATTRIBUTE = new Property<LocalDateTime>("timestampAttribute");
    public static final Property<List<MtTable2>> TABLE2ARRAY = new Property<List<MtTable2>>("table2Array");

    public void setDateAttribute(LocalDate dateAttribute) {
        writeProperty("dateAttribute", dateAttribute);
    }
    public LocalDate getDateAttribute() {
        return (LocalDate)readProperty("dateAttribute");
    }

    public void setGlobalAttribute(String globalAttribute) {
        writeProperty("globalAttribute", globalAttribute);
    }
    public String getGlobalAttribute() {
        return (String)readProperty("globalAttribute");
    }

    public void setOldDateAttribute(Date oldDateAttribute) {
        writeProperty("oldDateAttribute", oldDateAttribute);
    }
    public Date getOldDateAttribute() {
        return (Date)readProperty("oldDateAttribute");
    }

    public void setServerAttribute(String serverAttribute) {
        writeProperty("serverAttribute", serverAttribute);
    }
    public String getServerAttribute() {
        return (String)readProperty("serverAttribute");
    }

    public void setTimeAttribute(LocalTime timeAttribute) {
        writeProperty("timeAttribute", timeAttribute);
    }
    public LocalTime getTimeAttribute() {
        return (LocalTime)readProperty("timeAttribute");
    }

    public void setTimestampAttribute(LocalDateTime timestampAttribute) {
        writeProperty("timestampAttribute", timestampAttribute);
    }
    public LocalDateTime getTimestampAttribute() {
        return (LocalDateTime)readProperty("timestampAttribute");
    }

    public void addToTable2Array(MtTable2 obj) {
        addToManyTarget("table2Array", obj, true);
    }
    public void removeFromTable2Array(MtTable2 obj) {
        removeToManyTarget("table2Array", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<MtTable2> getTable2Array() {
        return (List<MtTable2>)readProperty("table2Array");
    }


}
