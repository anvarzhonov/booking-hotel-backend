package ru.ikbo2019.bookinghotel.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ikbo2019.bookinghotel.utils.MyDtoNullKeySerializer;

/**
 * todo Document type MapperConfig
 */
@Configuration
public class MapperConfig {

    @Bean
    public ObjectMapper mapper(){
        var mapper = new ObjectMapper();
        mapper.getSerializerProvider().setNullKeySerializer(new MyDtoNullKeySerializer());
//        mapper.setDefaultPropertyInclusion(
//            JsonInclude.Value.construct(JsonInclude.Include.ALWAYS, JsonInclude.Include.NON_NULL));
        return mapper;
    }
}
