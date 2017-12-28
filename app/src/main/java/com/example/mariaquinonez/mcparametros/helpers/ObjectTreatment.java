package com.example.mariaquinonez.mcparametros.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**|
 * Created by maria.quinonez on 07/12/2017.
 */

public class ObjectTreatment {

    public static String parseObjectToStr(Object request){
        String result="{}";
            ObjectMapper mapper= getObjectMapper();

                try {
                    result= mapper.writeValueAsString(request);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
        return result;
    }

    public  static <T> T parseStrToObject(String strJson, Class<T> typeClass){
        T resultObject=null;

            ObjectMapper mapper= new ObjectMapper();
            try {
                resultObject= mapper.readValue(strJson.toString(),typeClass);
            } catch (IOException e) {
                e.printStackTrace();
            }

        return  resultObject;
    }

    public static ObjectMapper getObjectMapper(){
        ObjectMapper mapper= new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        mapper.disable(MapperFeature.AUTO_DETECT_CREATORS,
                        MapperFeature.AUTO_DETECT_FIELDS,
                MapperFeature.AUTO_DETECT_GETTERS,
                MapperFeature.AUTO_DETECT_IS_GETTERS);

        return mapper;
    }
}
