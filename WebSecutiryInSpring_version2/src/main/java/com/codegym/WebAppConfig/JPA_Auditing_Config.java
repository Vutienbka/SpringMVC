//package com.codegym.WebAppConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//@Configuration
////@EnableJpaAuditing(auditorAwareRef = "auditorProvider") // Can khai bao annotation nay de dung duoc AuditorAware<String>
//public class JPA_Auditing_Config {
//    @Bean
//    public AuditorAware<String> auditorProvider(){
//        return new JpaAuditingConfig.AuditorAwareImpl();
//    }
//    public static class JpaAuditingConfig {
//        public static class AuditorAwareImpl implements AuditorAware<String>{
//            @Override
//            public String getCurrentAuditor() {
//                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//                if(authentication == null)
//                    return null;
//                return authentication.getName();
//                //Se tim trong cot BaseModel co cac truong duoc danh dau @CreatedBy va @ModifiedBy va set du lieu tu dong cho no
//            }
//        }
//    }
//}
