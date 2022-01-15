package com.tutego.date4u.shell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class FsCommandsTest {

  @Nested
  @DisplayName( "formatAsGigibyte" )
  class TestFormat {

    @Test
    void format_valid_gigibyte() {

      // given

      long value = 1_073_741_824;

      // when

      String actual = FsCommands.formatAsGigibyte( value );

      // then

      // assertEquals( "1 GiB", actual );
      assertThat( actual ).isEqualTo( "1 GiB" );
    }

    @Test
    void format_negative_gigibyte_expect_exception() {
      long value = -1_073_741_824;
      //      assertThrows( IllegalArgumentException.class, () -> {
      //        FsCommands.formatAsGigibyte( value );
      //      } );
      assertThatThrownBy( () -> {
        FsCommands.formatAsGigibyte( value );
      } ).isInstanceOf( IllegalArgumentException.class );
    }
  }
}