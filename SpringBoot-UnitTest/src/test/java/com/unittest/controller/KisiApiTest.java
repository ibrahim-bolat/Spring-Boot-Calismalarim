package com.unittest.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.unittest.dto.KisiDto;
import com.unittest.service.KisiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = KisiApi.class)
class KisiApiTest {


    @Autowired
    private  MockMvc mockMvc;

    @Autowired
    private  ObjectMapper objectMapper;

    @MockBean
    private KisiService kisiService;

    @Test
    void whenCalledkisiEkleWithKisiDto_thenReturn200Status() throws Exception {

        // given
        //altta nethod

        //when
        ResultActions actions = mockMvc.perform(post("/kisi/ekle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kisiDtoCreate())));

        //then
        ArgumentCaptor<KisiDto> captor = ArgumentCaptor.forClass(KisiDto.class);
        verify(kisiService, times(1)).kisiEkle(captor.capture());
        assertThat(captor.getValue().getAd()).isEqualTo("Ahmet");
        assertThat(captor.getValue().getSoyad()).isEqualTo("Narin");
        assertThat(captor.getValue().getGelir()).isEqualTo(25_000L);
        assertThat(captor.getValue().getDogumTarihi()).isEqualTo(LocalDate.of(1997,05,13));
        actions.andExpect(status().isOk());

    }

    @Test
    void whenCalledkisiEkleWithFalseData_thenReturn400Status() throws Exception {
        // given

        //when
        ResultActions actions = mockMvc.perform(post("/kisi/ekle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString("saçma data")));

        //then
        actions.andExpect(status().isBadRequest());

    }

    @Test
    void whenCalledkisiGuncelleWithTrueIdAndKisiDto_thenReturn200Status() throws Exception {

        // given
        //altta nethod

        when(this.kisiService.kisiGuncelle("IB",kisiDtoCreate())).thenReturn(kisiDtoCreate());

        // when
        ResultActions actions = mockMvc.perform(put("/kisi/guncelle/{id}","IB")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(kisiDtoCreate())));


        //then
        ArgumentCaptor<KisiDto> captor = ArgumentCaptor.forClass(KisiDto.class);
        verify(kisiService, times(1)).kisiGuncelle(eq("IB"),captor.capture());
        assertThat(captor.getValue().getAd()).isEqualTo("Ahmet");
        assertThat(captor.getValue().getSoyad()).isEqualTo("Narin");
        assertThat(captor.getValue().getGelir()).isEqualTo(25_000L);
        assertThat(captor.getValue().getDogumTarihi()).isEqualTo(LocalDate.of(1997,05,13));
        actions.andExpect(status().isOk());

    }

    @Test
    void whenCalledkisiListele_thenReturns200AndAllKisiDtoList() throws Exception {
        // given
        //altta nethod

        when(kisiService.kisiListele()).thenReturn(createKisiDtoList());

        // when
        MvcResult mvcResult = mockMvc.perform(get("/kisi")
                .accept(MediaType.APPLICATION_JSON)).andReturn();


        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(kisiService, times(1)).kisiListele();
        assertThat(objectMapper.writeValueAsString(createKisiDtoList()))
                .isEqualToIgnoringWhitespace(responseBody);
    }

    @Test
    void whenCalledkisiListele_thenReturnsNoData() throws Exception {
        // given
        when(kisiService.kisiListele()).thenReturn(Collections.emptyList());

        // when
        MvcResult mvcResult = mockMvc.perform(get("/kisi")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(kisiService, times(1)).kisiListele();
        assertThat(objectMapper.writeValueAsString(Collections.emptyList()))
                .isEqualToIgnoringWhitespace(responseBody);
    }
    @Test
    void whenCalledkisiGetirWithTrueId_thenReturns200() throws Exception {
            // given
            when(kisiService.kisiGetir("IB")).thenReturn(kisiDtoCreate());

            // when
           MvcResult mvcResult = mockMvc.perform(get("/kisi/getir/{id}","IB")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

            // then
            String responseBody = mvcResult.getResponse().getContentAsString();
            verify(kisiService, times(1)).kisiGetir("IB");
            assertThat(objectMapper.writeValueAsString(kisiDtoCreate()))
                    .isEqualToIgnoringWhitespace(responseBody);
    }

    @Test
    void whenCalledkisiGetirWithFalseId__thenReturnsNoData() throws Exception {
        // given
        when(kisiService.kisiGetir("BL")).thenReturn(null);

        // when
        MvcResult mvcResult = mockMvc.perform(get("/kisi/getir/{id}","BL")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // then
        verify(kisiService, times(1)).kisiGetir("BL");
        assertThat(objectMapper.writeValueAsString(null))
                .isNotBlank();

    }
    @Test
    void whenCalledkisiSilWithTrueId_thenReturns200andTrue() throws Exception {
        // given
        when(kisiService.kisiSil(anyString())).thenReturn(true);

        // when
        MvcResult mvcResult = mockMvc.perform(delete("/kisi/sil/{id}","IB")
                .accept(MediaType.APPLICATION_JSON)).andReturn();


        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(kisiService, times(1)).kisiSil(eq("IB"));
        assertThat(objectMapper.writeValueAsString(true))
                .isEqualToIgnoringWhitespace(responseBody);
    }

    @Test
    void whenCalledkisiSilWithFalseId_thenReturnsFalse() throws Exception {
        // given
        when(kisiService.kisiSil(anyString())).thenReturn(false);

        // when
        MvcResult mvcResult = mockMvc.perform(delete("/kisi/sil/{id}","BL")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(kisiService, times(1)).kisiSil(eq("BL"));
        assertThat(objectMapper.writeValueAsString(false))
                .isEqualToIgnoringWhitespace(responseBody);

    }


    private  KisiDto kisiDtoCreate(){
        KisiDto kisiDto=new KisiDto();
        kisiDto.setAd("Ahmet");
        kisiDto.setSoyad("Narin");
        kisiDto.setDogumTarihi(LocalDate.of(1997,05,13));
        kisiDto.setGelir(25_000L);
        return kisiDto;
    }

    private  List<KisiDto> createKisiDtoList(){
        return List.of(kisiDtoCreate(),kisiDtoCreate());
    }
}