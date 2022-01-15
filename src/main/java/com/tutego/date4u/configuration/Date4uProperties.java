package com.tutego.date4u.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// date4u.filesystem.freediskspace
@Component
@ConfigurationProperties( "date4u" )
public class Date4uProperties {

  public static class Filesystem {
    private long freediskspace;

    public long getFreediskspace() {
      return freediskspace;
    }

    public void setFreediskspace( long freediskspace ) {
      this.freediskspace = freediskspace;
    }
  }

  private Filesystem filesystem;

  public Filesystem getFilesystem() {
    return filesystem;
  }

  public void setFilesystem( Filesystem filesystem ) {
    this.filesystem = filesystem;
  }
}
