package com.tutego.date4u.event;

import java.time.OffsetDateTime;

public class NewPhotoEvent {

  public final String name;
  public final OffsetDateTime dateTime;

  public NewPhotoEvent( String name, OffsetDateTime dateTime ) {
    this.name = name;
    this.dateTime = dateTime;
  }

  @Override public String toString() {
    return "NewPhotoEvent{" +
           "name='" + name + '\'' +
           ", dateTime=" + dateTime +
           '}';
  }
}
