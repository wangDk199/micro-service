package com.soft1851.springboot.contentcenter.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.springboot.contentcenter.domain.dto.ExchangeDto;
import com.soft1851.springboot.contentcenter.domain.entity.Share;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ShareServiceTest {

    @Autowired
    private ShareService shareService;

    @Test
    void findById() {
    }

    @Test
    void query() {
        PageInfo<Share> query = shareService.query(null,1,20,1);
        List<Share> list = query.getList();
        list.forEach(item -> System.out.println(item.getTitle()+","+item.getDownloadUrl()));
    }

    @Test
    void exchange() {
        ExchangeDto exchangeDto = ExchangeDto.builder()
                .userId(1)
                .shareId(12)
                .build();
        System.out.println(this.shareService.exchange(exchangeDto));
    }
}