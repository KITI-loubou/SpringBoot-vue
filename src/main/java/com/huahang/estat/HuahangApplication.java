package com.huahang.estat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auth: pipi
 * @Desc: �����ǻ���ҵ����ϵͳ-springBoot������
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.huahang.estat.dao"}) //ɨ��̳���TKMapper Mapper<T>�ӿڵĽӿ�
public class HuahangApplication<MapperScan> {

    public static void main(String[] args) {
        SpringApplication.run(HuahangApplication.class, args);
    }

}
