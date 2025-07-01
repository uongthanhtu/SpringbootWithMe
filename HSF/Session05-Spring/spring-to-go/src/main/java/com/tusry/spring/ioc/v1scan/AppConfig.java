package com.tusry.spring.ioc.v1scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tusry.spring.ioc.v1scan")
//RA LỆNH CHO THƯ VIỆN QUÉT QUA TẤT CẢ TOÀN BỘ CLASS TRONG THƯ MỤC Ở TRÊN  XEM OBJECT NÀO CẦN TẠO RA HAY KHÔNG THÌ TẠO NEW LUÔN GIUM ĐỂ LÁT LÔI RA DÙNG
//ĐỂ PHÂN BIỆT OBJECT NÀO CẦN TẠO, OBJECT NÀO KHÔNG THÌ ĐÁNH DẤU CLASS BẰNG 1 TRONG BA Anotation
public class AppConfig {
}
