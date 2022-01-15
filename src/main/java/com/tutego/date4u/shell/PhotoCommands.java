package com.tutego.date4u.shell;

import com.tutego.date4u.photo.PhotoService;
import org.springframework.boot.ImageBanner;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@ShellComponent
public class PhotoCommands {

  private final PhotoService photoService;

  public PhotoCommands( PhotoService photoService ) {
    this.photoService = photoService;
  }

  @ShellMethod( "Show photo" )
  void showPhoto( String name ) {  // show-photo
    Optional<byte[]> maybeBytes = photoService.download( name );
    maybeBytes.ifPresent( bytes ->
                              new ImageBanner( new ByteArrayResource( bytes ) )
                                  .printBanner( new StandardEnvironment(), null, System.out ) );
  }

  @ShellMethod( "Upload photo" )  // upload-photo
  String uploadPhoto( String filename ) throws IOException {
    byte[] bytes = Files.readAllBytes( Paths.get( filename ) );
    return "Uploaded " + photoService.upload( bytes );
  }
}
