package com.tutego.date4u.shell;

import com.tutego.date4u.FileSystem;
import com.tutego.date4u.configuration.Date4uProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.Assert;
import org.springframework.util.unit.DataSize;

@ShellComponent
public class FsCommands {

  private final Logger log = LoggerFactory.getLogger( getClass() );

  private final Environment environment;
  private final FileSystem fs;
  private final Date4uProperties date4uProperties;

  public static String formatAsGigibyte( long value ) {
    Assert.isTrue( value >= 0, "Value has to be positive or 0" );
    // MiB 1024
    // MiB 1024^2
    // GiB 1024^3 => (2^10)^3 => 2^(10*3)
    return (value >> 30) + " GiB";
  }

  public FsCommands( Environment environment, FileSystem fs,
                     Date4uProperties date4uProperties ) {
    this.environment = environment;
    this.fs = fs;
    this.date4uProperties = date4uProperties;

    long freediskspace = date4uProperties.getFilesystem().getFreediskspace();
    if ( fs.getFreeDiskSpace() < freediskspace ) {
      log.info( "Low disk space, less than {}", freediskspace );
    }
  }

  @ShellMethod( "Show application version" )
  public String version() {
    return "0.1";
  }

  // free-disk-space
  @ShellMethod( "Show free disk space" )
  public String freeDiskSpace() {
    return DataSize.ofBytes( fs.getFreeDiskSpace() ).toGigabytes() + " GB";
  }

  @ShellMethod( "Show user home" )
  public String userHome() {
    return environment.getProperty( "user.home" );
  }

  //    @ShellMethod("Lowercase string")  // to-lower-case
  //    public String toLowerCase(String input) {
  //        return input.toLowerCase(Locale.ROOT);
  //    }

  //    @ShellMethod("Add")
  //    public void add(int a, int b) {
  //        System.out.println(a + b);
  //    }

}
