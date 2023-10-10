package org.dbms.database.component.column;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.dbms.database.component.Column;

public class ComplexIntegerColumn extends Column {

  public ComplexIntegerColumn(String name) {
    super(name);
    this.type = ColumnType.COMPLEXINT.name();
  }

  @Override
  public boolean validate(String data) {
    // Define a regular expression pattern for complex numbers
    String complexIntegerPattern = "^(0|[-]?[1-9]\\d*)([-+](0|[1-9]\\d*))i$";
    Pattern pattern = Pattern.compile(complexIntegerPattern);
    Matcher matcher = pattern.matcher(data);

    // Check if the input data matches the pattern
    if (matcher.matches() || data.isEmpty()) {
      // If it matches, it's a valid complex number
      return true;
    } else {
      // If it doesn't match, it's not a valid complex number
      return false;
    }
  }
}

