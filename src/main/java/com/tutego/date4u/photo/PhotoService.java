package com.tutego.date4u.photo;

import com.tutego.date4u.FileSystem;
import com.tutego.date4u.event.NewPhotoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {
  private final FileSystem fs;
  private final Thumbnail thumbnail;
  // private final ApplicationEventPublisher publisher;

  public PhotoService( FileSystem fs, Thumbnail thumbnail) {
    this.fs = fs;
    this.thumbnail = thumbnail;
  }

  public Optional<byte[]> download( String name ) {
    try {
      return Optional.of( fs.load( name + ".jpg" ) );
    }
    catch ( UncheckedIOException e ) {
      return Optional.empty();
    }
  }

  public String upload( byte[] imageBytes ) {
    String imageName = UUID.randomUUID().toString();

    //    NewPhotoEvent newPhotoEvent = new NewPhotoEvent( imageName, OffsetDateTime.now() );
    //    publisher.publishEvent( newPhotoEvent );

    // First: store original image
    fs.store( imageName + ".jpg", imageBytes );

    // Second: store thumbnail
    byte[] thumbnailBytes = thumbnail.thumbnail( imageBytes );
    fs.store( imageName + "-thumb.jpg", thumbnailBytes );

    return imageName;
  }
}
