package fr.studi.interspe.ws;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

import fr.studi.interspe.pojo.Status;

public class StringToEnumStatusConverter implements Converter<String, Status> {

  @Override
  public Status convert(String stringStatus) {
    try {
      return Status.valueOf(stringStatus.toUpperCase());
  } catch (IllegalArgumentException e) {
      return null;
  }
}

  @Override
  public JavaType getInputType(TypeFactory arg0) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getInputType'");
  }

  @Override
  public JavaType getOutputType(TypeFactory arg0) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOutputType'");
  }
  
}
