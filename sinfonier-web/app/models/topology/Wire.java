package models.topology;

import static models.SinfonierConstants.Wire.FIELD_SOURCES;
import static models.SinfonierConstants.Wire.FIELD_SOURCES_ANNOTATION;
import static models.SinfonierConstants.Wire.FIELD_TARGET;
import static models.SinfonierConstants.Wire.FIELD_TARGET_ANNOTATION;
import static models.SinfonierConstants.Wire.FIELD_XTYPE;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Wire implements Serializable{
  private String xtype;
  
  @SerializedName(FIELD_SOURCES_ANNOTATION)
  private Point source;
  
  @SerializedName(FIELD_TARGET_ANNOTATION)
  private Point target;

  public Wire(String xType, Point source, Point target) {
    this.xtype = xType;
    this.source = source;
    this.target = target;
  }

  public Wire(DBObject o) {
    if (o != null) {
      xtype = o.get(FIELD_XTYPE).toString();
      source = new Point(((DBObject) o.get(FIELD_SOURCES)));
      target = new Point(((DBObject) o.get(FIELD_TARGET)));
    }
  }

  public DBObject toDBObject() {
    DBObject object = new BasicDBObject();

    if (xtype != null) {
      object.put(FIELD_XTYPE, xtype);
      object.put(FIELD_SOURCES, source.toDBObject());
      object.put(FIELD_TARGET, target.toDBObject());
    }

    return object;
  }

  public String getxType() {
    return xtype;
  }

  public void setxType(String xType) {
    this.xtype = xType;
  }

  public Point getSource() {
    return source;
  }

  public void setSource(Point source) {
    this.source = source;
  }

  public Point getTarget() {
    return target;
  }

  public void setTarget(Point target) {
    this.target = target;
  }

  @Override
  public String toString() {
    return toDBObject().toString();
  }
}
