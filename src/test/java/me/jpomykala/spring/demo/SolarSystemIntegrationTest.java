package me.jpomykala.spring.demo;

import me.jpomykala.spring.demo.service.MoonService;
import me.jpomykala.spring.demo.service.WorldService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Evelan on 23/10/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SolarSystemIntegrationTest {

    @Autowired
    WorldService worldService;

    @MockBean
    MoonService moonService;

    @Autowired
    MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Test
    public void setMockMvc() throws Exception {
        mockMvc.perform(get("http://localhost:" + this.port + "/home")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"));


    }


    @Before
    public void setup() {
        given(moonService.getTemperature()).willReturn(53.32f);
    }

    @Test
    public void whenAppendingWorld_correct() throws Exception {
        //when
        String body = worldService.appendWorld("Hello ");
        //then
        assertThat(body).isEqualTo("Hello World");
    }

    @Test
    public void whenGettingTemperature_correct() throws Exception {
        //when
        Float temperature = moonService.getTemperature();

        //then
        assertThat(temperature).isEqualTo(53.32f);
    }


}