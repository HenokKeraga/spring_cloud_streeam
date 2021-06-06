package edu.miu.sptingcloudfunction.config;


//import org.springframework.cloud.stream.function.StreamBridge;
import edu.miu.sptingcloudfunction.binding.ChannelBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
@EnableBinding(ChannelBinding.class)
public class ProjectConfig {
    //expecting invoked by  string and producing string
    //functional composition
    //spring cloud stream ->underline the broker API
    //default publish subscribe
    //type conversion ->


//    @Bean
//    public Supplier<String> supplier(){
//        return ()-> {
//            return "hello :: "+System.currentTimeMillis();};
//    }

    @Bean
    public Function<String, String> process() {

        return s -> {
            System.out.println("::::::::::::::::::::::");
          //  bridge.send("blah","hello from blah");
            return s.toUpperCase();
        };
    }

//    @Bean
//    public Function<String, String> size() {
//
//        return s -> {
//            System.out.println("size :::: :::::::");
//            return s +s.length();
//        };
//    }

//    @Bean
//    public Consumer<String> consumer(){
//        return s -> System.out.println(s);
//    }
}
