package org.dbms.database.component.column;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.dbms.database.component.Column;

public class ComplexRealColumn extends Column {

  public ComplexRealColumn(String name){
    super(name);
    this.type = ColumnType.COMPLEXREAL.name();
  }

  @Override
  public boolean validate(String data) {
    // Define a regular expression pattern for complex numbers
    String complexIntegerPattern = "^(0|[-]?0(\\.\\d+)|[-]?[1-9]\\d*(\\.\\d+)?)([-+](0(\\.\\d+)?|[1-9]\\d*(\\.\\d+)?))i$";
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
