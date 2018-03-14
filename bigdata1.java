// ORM class for table 'bigdata1'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri Jan 19 12:19:10 CST 2018
// For connector: org.apache.sqoop.manager.GenericJdbcManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class bigdata1 extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer class_id;
  public Integer get_class_id() {
    return class_id;
  }
  public void set_class_id(Integer class_id) {
    this.class_id = class_id;
  }
  public bigdata1 with_class_id(Integer class_id) {
    this.class_id = class_id;
    return this;
  }
  private String class_name;
  public String get_class_name() {
    return class_name;
  }
  public void set_class_name(String class_name) {
    this.class_name = class_name;
  }
  public bigdata1 with_class_name(String class_name) {
    this.class_name = class_name;
    return this;
  }
  private Integer class_month;
  public Integer get_class_month() {
    return class_month;
  }
  public void set_class_month(Integer class_month) {
    this.class_month = class_month;
  }
  public bigdata1 with_class_month(Integer class_month) {
    this.class_month = class_month;
    return this;
  }
  private String teacher;
  public String get_teacher() {
    return teacher;
  }
  public void set_teacher(String teacher) {
    this.teacher = teacher;
  }
  public bigdata1 with_teacher(String teacher) {
    this.teacher = teacher;
    return this;
  }
  private java.sql.Timestamp last_mod_ts;
  public java.sql.Timestamp get_last_mod_ts() {
    return last_mod_ts;
  }
  public void set_last_mod_ts(java.sql.Timestamp last_mod_ts) {
    this.last_mod_ts = last_mod_ts;
  }
  public bigdata1 with_last_mod_ts(java.sql.Timestamp last_mod_ts) {
    this.last_mod_ts = last_mod_ts;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof bigdata1)) {
      return false;
    }
    bigdata1 that = (bigdata1) o;
    boolean equal = true;
    equal = equal && (this.class_id == null ? that.class_id == null : this.class_id.equals(that.class_id));
    equal = equal && (this.class_name == null ? that.class_name == null : this.class_name.equals(that.class_name));
    equal = equal && (this.class_month == null ? that.class_month == null : this.class_month.equals(that.class_month));
    equal = equal && (this.teacher == null ? that.teacher == null : this.teacher.equals(that.teacher));
    equal = equal && (this.last_mod_ts == null ? that.last_mod_ts == null : this.last_mod_ts.equals(that.last_mod_ts));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof bigdata1)) {
      return false;
    }
    bigdata1 that = (bigdata1) o;
    boolean equal = true;
    equal = equal && (this.class_id == null ? that.class_id == null : this.class_id.equals(that.class_id));
    equal = equal && (this.class_name == null ? that.class_name == null : this.class_name.equals(that.class_name));
    equal = equal && (this.class_month == null ? that.class_month == null : this.class_month.equals(that.class_month));
    equal = equal && (this.teacher == null ? that.teacher == null : this.teacher.equals(that.teacher));
    equal = equal && (this.last_mod_ts == null ? that.last_mod_ts == null : this.last_mod_ts.equals(that.last_mod_ts));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.class_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.class_name = JdbcWritableBridge.readString(2, __dbResults);
    this.class_month = JdbcWritableBridge.readInteger(3, __dbResults);
    this.teacher = JdbcWritableBridge.readString(4, __dbResults);
    this.last_mod_ts = JdbcWritableBridge.readTimestamp(5, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.class_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.class_name = JdbcWritableBridge.readString(2, __dbResults);
    this.class_month = JdbcWritableBridge.readInteger(3, __dbResults);
    this.teacher = JdbcWritableBridge.readString(4, __dbResults);
    this.last_mod_ts = JdbcWritableBridge.readTimestamp(5, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(class_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(class_name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(class_month, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(teacher, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(last_mod_ts, 5 + __off, 93, __dbStmt);
    return 5;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(class_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(class_name, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(class_month, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(teacher, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(last_mod_ts, 5 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.class_id = null;
    } else {
    this.class_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.class_name = null;
    } else {
    this.class_name = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.class_month = null;
    } else {
    this.class_month = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.teacher = null;
    } else {
    this.teacher = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.last_mod_ts = null;
    } else {
    this.last_mod_ts = new Timestamp(__dataIn.readLong());
    this.last_mod_ts.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.class_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.class_id);
    }
    if (null == this.class_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, class_name);
    }
    if (null == this.class_month) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.class_month);
    }
    if (null == this.teacher) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, teacher);
    }
    if (null == this.last_mod_ts) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.last_mod_ts.getTime());
    __dataOut.writeInt(this.last_mod_ts.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.class_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.class_id);
    }
    if (null == this.class_name) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, class_name);
    }
    if (null == this.class_month) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.class_month);
    }
    if (null == this.teacher) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, teacher);
    }
    if (null == this.last_mod_ts) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.last_mod_ts.getTime());
    __dataOut.writeInt(this.last_mod_ts.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(class_id==null?"null":"" + class_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(class_name==null?"null":class_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(class_month==null?"null":"" + class_month, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(teacher==null?"null":teacher, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_mod_ts==null?"null":"" + last_mod_ts, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(class_id==null?"null":"" + class_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(class_name==null?"null":class_name, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(class_month==null?"null":"" + class_month, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(teacher==null?"null":teacher, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(last_mod_ts==null?"null":"" + last_mod_ts, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.class_id = null; } else {
      this.class_id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.class_name = null; } else {
      this.class_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.class_month = null; } else {
      this.class_month = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.teacher = null; } else {
      this.teacher = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.last_mod_ts = null; } else {
      this.last_mod_ts = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.class_id = null; } else {
      this.class_id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.class_name = null; } else {
      this.class_name = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.class_month = null; } else {
      this.class_month = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.teacher = null; } else {
      this.teacher = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.last_mod_ts = null; } else {
      this.last_mod_ts = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    bigdata1 o = (bigdata1) super.clone();
    o.last_mod_ts = (o.last_mod_ts != null) ? (java.sql.Timestamp) o.last_mod_ts.clone() : null;
    return o;
  }

  public void clone0(bigdata1 o) throws CloneNotSupportedException {
    o.last_mod_ts = (o.last_mod_ts != null) ? (java.sql.Timestamp) o.last_mod_ts.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("class_id", this.class_id);
    __sqoop$field_map.put("class_name", this.class_name);
    __sqoop$field_map.put("class_month", this.class_month);
    __sqoop$field_map.put("teacher", this.teacher);
    __sqoop$field_map.put("last_mod_ts", this.last_mod_ts);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("class_id", this.class_id);
    __sqoop$field_map.put("class_name", this.class_name);
    __sqoop$field_map.put("class_month", this.class_month);
    __sqoop$field_map.put("teacher", this.teacher);
    __sqoop$field_map.put("last_mod_ts", this.last_mod_ts);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("class_id".equals(__fieldName)) {
      this.class_id = (Integer) __fieldVal;
    }
    else    if ("class_name".equals(__fieldName)) {
      this.class_name = (String) __fieldVal;
    }
    else    if ("class_month".equals(__fieldName)) {
      this.class_month = (Integer) __fieldVal;
    }
    else    if ("teacher".equals(__fieldName)) {
      this.teacher = (String) __fieldVal;
    }
    else    if ("last_mod_ts".equals(__fieldName)) {
      this.last_mod_ts = (java.sql.Timestamp) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("class_id".equals(__fieldName)) {
      this.class_id = (Integer) __fieldVal;
      return true;
    }
    else    if ("class_name".equals(__fieldName)) {
      this.class_name = (String) __fieldVal;
      return true;
    }
    else    if ("class_month".equals(__fieldName)) {
      this.class_month = (Integer) __fieldVal;
      return true;
    }
    else    if ("teacher".equals(__fieldName)) {
      this.teacher = (String) __fieldVal;
      return true;
    }
    else    if ("last_mod_ts".equals(__fieldName)) {
      this.last_mod_ts = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
