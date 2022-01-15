package com.tutego.date4u.photo;

import com.tutego.date4u.FileSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@ExtendWith( MockitoExtension.class )
@SpringBootTest( { "spring.shell.interactive.enabled=false" } )
class PhotoServiceTest {

  private static final byte[] MINIMAL_JPG = Base64.getDecoder().decode(
      "/9j/4AAQSkZJRgABAQEASABIAAD"
      + "/2wBDAP////////////////////////////////////////////////////////////"
      + "//////////////////////////wgALCAABAAEBAREA/8QAFBABAAAAAAAAAAAAAAAAA"
      + "AAAAP/aAAgBAQABPxA=" );                      // https://git.io/J9GXr

//  @Mock( lenient = true ) FileSystem fs;
//  @Spy AwtBicubicThumbnail thumbnail;
//  @InjectMocks PhotoService photoService;
  @MockBean FileSystem fs;
  @Autowired PhotoService photoService;

  @Test
  void successful_photo_upload() {
    String imageName = photoService.upload( MINIMAL_JPG );
    assertThat( imageName ).isNotEmpty();
//    verify( fs, times( 2 ) ).store( anyString(), any( byte[].class ) );
//    verify( thumbnail ).thumbnail( any( byte[].class ) );
  }
}

